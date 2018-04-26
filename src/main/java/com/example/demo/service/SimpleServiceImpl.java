package com.example.demo.service;


import org.springframework.stereotype.Service;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
@Service("simpleService")
public class SimpleServiceImpl implements SimpleService {

    public void foo() {
        System.out.println("foo......");
        this.bar();
    }

    public void bar() {
        System.out.println("bar.....");
    }

    public void findAll(){
        System.out.println("Pattern findAll");
    }
}
