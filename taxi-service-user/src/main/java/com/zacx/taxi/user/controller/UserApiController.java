package com.zacx.taxi.user.controller;


import com.zacx.taxi.user.api.UserApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
* @desc    用户接口
* @version 1.0
* @author  Liang Jun
* @date    2020年04月16日 18:06:05
**/
@RestController
public class UserApiController implements UserApi {
    @Override
    public String getHi() {
        return "hi, I'm xxoo!";
    }
}