package com.zacx.taxi.user.api;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月24日 17:22:54
**/
@Component
public class HystrixAPIFallbackFactory implements FallbackFactory<HystrixAPI> {
    @Override
    public HystrixAPI create(Throwable e) {
        return new HystrixAPI() {
            @Override
            public String greet(String name) {
                e.printStackTrace();
                return "很抱歉降级了" + name;
            }
        };
    }
}