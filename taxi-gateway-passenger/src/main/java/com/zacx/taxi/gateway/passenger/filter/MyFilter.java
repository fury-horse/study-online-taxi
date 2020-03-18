package com.zacx.taxi.gateway.passenger.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年02月29日 23:07:03
**/
//@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL()));
        Object accessToken = request.getParameter("token");

        if (accessToken == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("ok");
        return null;
    }
}