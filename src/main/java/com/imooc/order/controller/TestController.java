package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@Slf4j
public class TestController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;
//    @GetMapping("/getProductMsg")
//    public String getProductMsg(){
//        //1.第一种方式(直接使用restTemplate,url写死)
//        // 对有多个product地址是一种考验
//        //RestTemplate restTemplate=new RestTemplate();
//        //String response=restTemplate.getForObject("http://localhost:8080/msg",String.class);
//        //2.第二种方式(利用loadBalancerClient通过应用名获取url[post和端口],然后再使用RestTemplate)
//        RestTemplate restTemplate=new RestTemplate();
//        ServiceInstance serviceInstance=loadBalancerClient.choose("PRODUCT");
//        serviceInstance.getHost();
//        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
//        String response=restTemplate.getForObject(url,String.class);
//        //3.第三种方式(利用@LoadBalanced,可在restTemplate里使用应用名字)，实质上和第二种一样
////        String response=restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",response);
//        return response;
//    }
}
