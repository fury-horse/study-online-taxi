package com.zacx.taxi.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月22日 00:40:26
**/
@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/he")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi" + name + ", I am from port:" + port;
    }
}