package com.imooc.order.controller;

import com.imooc.order.VO.ResultVO;
import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    //订单服务的业务逻辑
    //1.参数校验
    //2.查询商品信息(调用商品服务)
    //3.计算总价
    //4.扣库存(调用商品服务)
    //5.订单入库
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    //前端传过来的参数需要表单验证，所以用表单对象
    //这个抛出异常是大错误，细分的话详见form2dto
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        //orderForm->orderDTO，需要一个工具类转换
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        //第一次判断是吧表单数据当字符串判断
        // 第二次判断转换完的数据里的items是否为空
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result=orderService.create(orderDTO);
        //返回只有一个字段，所以用map来返回
        Map<String,String> map=new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtils.success(map);
    }
}
