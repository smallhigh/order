package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//商品表
@Data
@Entity
//@Table(name="xxx")
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    /*状态，0正常1下架*/
    //给状态一个默认值，解决新增修改在一个类下，状态属性不同导致报错的问题
    private Integer productStatus;
    //类目编号
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
