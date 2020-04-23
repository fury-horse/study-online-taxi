package com.zacx.taxi.user.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "TAXI-SERVICE-DEMO")
public interface DemoApi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayFromClientOne(@RequestParam(value = "name") String name);
}
