package com.example.demo.aspect;

import org.aspectj.lang.annotation.*;

/**
 * Author : Martin
 * Date : 2018/4/17
 * Description :
 */
@Aspect
public class OperationLogAspect {

    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    private void allLogRecord(){
    }
    
    @Before("allLogRecord()")
    private void doBefore(){
        System.out.println("doBefore........");
    }

    @After("allLogRecord()")
    private void doAfter(){
        System.out.println("doAfter......");
    }
    
}
