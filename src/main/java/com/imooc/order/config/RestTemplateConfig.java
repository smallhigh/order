package com.imooc.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//把RestTemplate作为bean配置,robbin会用到，feign不用
//@Component
public class RestTemplateConfig {
//    @Bean
//    //第二种方式是使用LoadBalancerClient注入
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
