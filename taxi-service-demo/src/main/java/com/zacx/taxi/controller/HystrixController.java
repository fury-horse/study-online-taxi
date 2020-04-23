package com.zacx.taxi.controller;


import com.zacx.taxi.service.HystrixService;
import com.zacx.taxi.user.api.HystrixAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
* @desc    熔断降级
* @version 1.0
* @author  Liang Jun
* @date    2020年02月24日 00:11:49
**/
@RestController
public class HystrixController {
    @Autowired
    private HystrixService hystrixService; //RestTemplate调用
    @Autowired
    private HystrixAPI hystrixAPI; //Feign调用

    @RequestMapping("/home")
    public String home(@RequestParam(value = "name", defaultValue = "(●'◡'●)") String name) {
//        return hystrixService.greet(name);
        return hystrixAPI.greet(name);
    }

}