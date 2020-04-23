package com.zacx.taxi.user.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @desc    用户接口
* @version 1.0
* @author  Liang Jun
* @date    2020年04月16日 18:00:59
**/
@RequestMapping("user")
public interface UserApi {
    @GetMapping("getHi")
    public String getHi();
}