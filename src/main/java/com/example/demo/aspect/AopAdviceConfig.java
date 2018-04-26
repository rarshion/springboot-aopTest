package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Author : Martin
 * Date : 2018/4/17
 * Description :
 */
@Aspect
public class AopAdviceConfig {
    
    @Before("execution(* com.example.demo.service..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getThis());
        System.out.println("我是前置通知....");
    }
    
    @After("execution(* com.example.demo.service..*.*(..))")
    public void AfterAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getThis());
        System.out.println("我是后置通知....");
    }
}

