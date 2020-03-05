package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;
//考虑到入参和返回，以及一条主表可能含有多个详情表（一对多），所以使用dto
public interface OrderService {
    //创建订单
    OrderDTO create(OrderDTO orderDTO);
}
