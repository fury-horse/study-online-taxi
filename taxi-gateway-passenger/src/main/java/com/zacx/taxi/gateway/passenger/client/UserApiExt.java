package com.zacx.taxi.gateway.passenger.client;


import com.zacx.taxi.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年04月16日 21:30:25
**/
@FeignClient(value = "TAXI-SERVICE-USER")
public interface UserApiExt extends UserApi {
}