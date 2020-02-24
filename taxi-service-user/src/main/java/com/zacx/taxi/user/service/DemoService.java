package com.zacx.taxi.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月22日 01:09:48
**/
@Service
public class DemoService {
    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://TAXI-SERVICE-DEMO/hi?name=" + name, String.class);
    }
}