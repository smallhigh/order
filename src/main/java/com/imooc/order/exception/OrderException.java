package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;
//异常类
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code=code;
    }
    //再加一个构造方法，这个小异常需要抛一个message
    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
