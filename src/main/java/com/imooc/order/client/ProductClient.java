package com.imooc.order.client;
//Feign用到的接口
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//name填访问那个应用的接口
@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
