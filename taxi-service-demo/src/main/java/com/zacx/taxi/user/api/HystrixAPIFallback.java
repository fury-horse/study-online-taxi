package com.zacx.taxi.user.api;


import org.springframework.stereotype.Component;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月24日 17:04:33
**/
@Component
public class HystrixAPIFallback implements HystrixAPI{
    @Override
    public String greet(String name) {
        return "很抱歉降级了，" + name;
    }
}