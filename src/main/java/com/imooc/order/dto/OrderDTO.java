package com.imooc.order.dto;

import com.imooc.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//数据传输对象
//create()参数需要OrderDetail,OrderMaster两个数据库的数据
//把这两个数据关联起来，关系是一对多的关系
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    //买家微信openid
    private String buyerOpenid;
    private BigDecimal orderAmount;
    //订单状态，默认为0新下单
    private Integer orderStatus;
    //支付状态，默认为0未支付
    private Integer payStatus;

    List<OrderDetail> orderDetailList;//= new ArrayList<>();
}
