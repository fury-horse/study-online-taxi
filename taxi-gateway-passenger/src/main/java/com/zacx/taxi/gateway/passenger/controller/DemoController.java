package com.zacx.taxi.gateway.passenger.controller;


import com.zacx.taxi.gateway.passenger.service.DemoService1;
import com.zacx.taxi.gateway.passenger.service.DemoService2;
import com.zacx.taxi.user.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年03月01日 22:22:49
**/
@RefreshScope
@RestController
public class DemoController {
    @Value("${env}")
    private String env;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DemoService1 demoService1;
    @Autowired
    private DemoService2 demoService2;
    @Autowired
    private UserApi userApi;

    @GetMapping("hello")
    public String hello() {
        return demoService1.hello();
    }

    @GetMapping("helloDemo")
    public String helloDemo() {
        return demoService2.helloDemo();
    }

    @GetMapping("getEnv")
    public String getEnv() {
        return env;
    }

    @GetMapping("getHi1")
    public String getHi1() {
        return new RestTemplate().getForObject("http://127.0.0.1:8001/hi?name=ABCD", String.class);
    }

    @GetMapping("getHi2")
    public String getHi2() {
        return restTemplate.getForObject("http://TAXI-SERVICE-USER/hi?name=ABCD", String.class);
    }

    @GetMapping("getHi3")
    public String getHi3() {
        return userApi.getHi();
    }
}