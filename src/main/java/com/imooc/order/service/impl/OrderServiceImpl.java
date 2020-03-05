package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

//商品服务处理完，在controller测试能通的时候，完成剩余TODO
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId=KeyUtil.genUniqueKey();
        //TOD 2.查询商品信息(调用商品服务)
        //根据前端输入的form参数看，通过参数里的productId集合来查询商品信息(去product写逻辑)
        List<String> productIdList=orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList=productClient.listForOrder(productIdList);
        //TOD 3.计算总价
        BigDecimal orderAmout=new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo: productInfoList){
                //productid相等进入计算
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价*数量,BigDecimal类型相乘的计算方法↓,.add之前是一件商品总价，加.add累计
                    orderAmout=productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //TOD 4.扣库存(调用商品服务)
        //lamd表达式返回一个对象时注意格式，不同于返回一个id，下面是返回一个新的对象
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream()
                .map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        //5.订单入库
        //注意用这个复制，看好先后顺序
        //入参来的OrderDTO（买家buyer只有四项数据）其他的数据没有，copy完剩下四项数据
        OrderMaster orderMaster=new OrderMaster();
        //注意先把orderId设置到dto里去
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
//        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setPayStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
