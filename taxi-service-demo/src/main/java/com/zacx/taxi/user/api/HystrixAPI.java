package com.zacx.taxi.user.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月24日 01:17:23
**/
//@FeignClient(value = "TAXI-SERVICE-USER", fallback = HystrixAPIFallback.class)
@FeignClient(value = "TAXI-SERVICE-USER", fallbackFactory = HystrixAPIFallbackFactory.class)
public interface HystrixAPI {
    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    String greet(@RequestParam(value = "name") String name);
}