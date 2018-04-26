package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Author : Martin
 * Date : 2018/4/17
 * Description :
 */
@Slf4j
public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) {
        if (method.getName().equals("beforeAdvise")){
            log.info("前置通知");
        }
        log.info(method.getName() + "retry-advice:before");
    }
}
