package com.example.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author ： Martin
 * Date : 18/2/5
 * Description :
 * Version : 2.0
 */
@Slf4j
public class TokenInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = StringUtils.trimToEmpty(request.getHeader("x-auth-token"));
        if (StringUtils.isNotEmpty(token)) {
            return super.preHandle(request, response, handler);
        }
        throw new RuntimeException("token empty");
    }
}