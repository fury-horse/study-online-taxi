package com.zacx.taxi.gateway.passenger.controller;


import com.zacx.taxi.gateway.passenger.service.DemoService;
import com.zacx.taxi.gateway.passenger.service.DemoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年03月01日 22:22:49
**/
@RefreshScope
@RestController
public class DemoController {
    //@Value("${env}")
    private String env;

    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoService2 demoService2;

    @GetMapping("hello")
    public String hello() {
        return demoService.hello();
    }

    @GetMapping("helloDemo")
    public String helloDemo() {
        return demoService2.helloDemo();
    }

    @GetMapping("getEnv")
    public String getEnv() {
        return env;
    }
}