package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;

import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void testSave(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("ordertest");
        orderDetail.setOrderId("333333");
        orderDetail.setProductIcon("http://aaa.jpg");
        orderDetail.setProductId("111111");
        orderDetail.setProductName("liuliuliu");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(1);

        OrderDetail result=orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result !=null);
    }

}