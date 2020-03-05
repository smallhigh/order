package com.imooc.order.dto;

import lombok.Data;

//在扣库存步骤中，order服务里接受的form表单中,可以收到的数据
//只有一个购物车（订单号与数量的集合），这里把这个购物车对象设置成一个dto
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    //注意下面加了一个构造方法，和@Data一起使用后，
    //@Data默认的无参构造方法就不起作用了，所以要手动加上
    public CartDTO(){
    }

    //购物车只有两个字段，加一个构造方法
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
