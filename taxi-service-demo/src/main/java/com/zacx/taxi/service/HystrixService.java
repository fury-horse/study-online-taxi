package com.zacx.taxi.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月24日 00:13:43
**/
@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "greetFail")
    public String greet(String name) {
        return restTemplate.getForObject("http://TAXI-SERVICE-USER/hi?name=" + name, String.class);
    }

    public String greetFail(String name, Throwable e) {
        e.printStackTrace();
        //备用逻辑
        return name + "很抱歉，被熔断了";
    }
}