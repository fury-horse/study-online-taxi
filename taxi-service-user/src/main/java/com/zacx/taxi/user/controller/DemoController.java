package com.zacx.taxi.user.controller;

import com.zacx.taxi.user.api.SchedualSercie;
import com.zacx.taxi.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @desc
* @version 1.0
* @author  Liang Jun
* @date    2020年02月22日 01:07:07
**/
@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private SchedualSercie schedualSercie;

    @GetMapping(value = "/home")
    public String home(@RequestParam String name) {
        return schedualSercie.sayFromClientOne(name);
    }
}