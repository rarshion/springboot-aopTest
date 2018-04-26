package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Author : Martin
 * Date : 2018/4/17
 * Description :
 */
@Service("testAspectService")
public class TestAspectServiceImpl implements TestAspectService {
    
    @Override
    public void beforeAdvice() {
        System.out.println("测试前置通知Service...");
    }
}
