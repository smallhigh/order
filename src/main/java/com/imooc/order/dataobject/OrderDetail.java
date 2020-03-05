package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;
    //订单id
    private String orderId;
    //商品id
    private String productId;
    //商品名
    private String productName;
    //商品价格
    private BigDecimal productPrice;
    //商品数量
    private Integer productQuantity;
    //小图
    private String productIcon;
}
