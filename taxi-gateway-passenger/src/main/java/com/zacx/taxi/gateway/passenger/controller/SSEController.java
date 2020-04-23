package com.zacx.taxi.gateway.passenger.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

/**
* @desc    模拟SSE
* @version 1.0
* @author  Liang Jun
* @date    2020年03月20日 14:40:29
**/
@RestController
public class SSEController {
    //produces = "text/event-stream;charset=UTF-8"一定要带上
    @RequestMapping(value = "/get_data", produces = "text/event-stream;charset=UTF-8")
    public String getData() throws Exception {
        Thread.sleep(1000);

        double moeny = Math.random() * 10;
        System.out.println(String.format("%.2f",moeny));

        DecimalFormat df = new DecimalFormat(".00");
        String canshu=df.format(moeny);
        //！！！注意，EventSource返回的参数必须以data:开头，"\n\n"结尾，不然onmessage方法无法执行。
        return "data:白菜价格行情:" + canshu+"元"+ "\n\n";
    }
}