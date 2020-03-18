package com.zacx.taxi.user.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "(●'◡'●)") String name) {
        return name + ", I am from port:" + port;
    }

    @GetMapping("token")
    public String token(HttpServletRequest request) {
        return "token=" + request.getHeader("token");
    }
}