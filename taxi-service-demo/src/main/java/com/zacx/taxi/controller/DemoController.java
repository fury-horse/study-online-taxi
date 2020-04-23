package com.zacx.taxi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
* @desc    demo
* @version 1.0
* @author  Liang Jun
* @date    2020年04月09日 09:01:48
**/
@RestController
public class DemoController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("client1")
    public String client1() {

        List<String> services = discoveryClient.getServices();
        for (String item : services) {
            System.out.println("service = " + item);

            List<ServiceInstance> instances = discoveryClient.getInstances(item);
            for (ServiceInstance instance : instances) {
                if (!instance.getServiceId().equalsIgnoreCase("taxi-service-user")) {
                    continue;
                }
                System.out.println("------------------------------------------------------------");
                System.out.println("serviceId = " + instance.getServiceId());

                ServiceInstance choose = loadBalancerClient.choose(instance.getServiceId());

                String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/hi";
                System.out.println("url = " + url);

                String result = new RestTemplate().getForObject(url, String.class);
                System.out.println("result = " + result);
                System.out.println("------------------------------------------------------------");
            }
        }

        return "client1 ok";
    }
}