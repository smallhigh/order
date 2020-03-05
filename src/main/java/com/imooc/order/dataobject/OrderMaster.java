package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class OrderMaster {
    @Id
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
    private Date createTime;
    private Date updateTime;
}
