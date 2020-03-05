package com.imooc.order.repository;


import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testSave(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("333333");
        orderMaster.setBuyerName("shidi");
        orderMaster.setBuyerPhone("13333333333");
        orderMaster.setBuyerAddress("mukewangzongbu");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result=orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result !=null);
    }
}