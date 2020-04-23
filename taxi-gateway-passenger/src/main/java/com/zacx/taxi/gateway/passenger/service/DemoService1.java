package com.zacx.taxi.gateway.passenger.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年03月01日 22:25:14
**/
@Service
public class DemoService1 {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        return restTemplate.getForObject("http://TAXI-SERVICE-USER/hi?name=ABCD", String.class);
    }

    public String helloFallback(Throwable throwable) {
        throwable.printStackTrace();
        return "sorry fallback";
    }
}