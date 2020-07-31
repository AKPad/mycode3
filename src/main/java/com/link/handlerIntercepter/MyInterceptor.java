package com.link.handlerIntercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    /*
    * false代表不放行
    * true代表放行
    *
    * 在达到目标方法之前执行（拦截方法）
    * */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println( "preHandle执行了..." );
        return true;
    }
}
