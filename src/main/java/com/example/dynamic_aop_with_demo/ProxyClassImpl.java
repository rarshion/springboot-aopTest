package com.example.dynamic_aop_with_demo;

/**
 * Author : Martin
 * Date : 2018/4/19
 * Description :
 */
public class ProxyClassImpl implements IProxyClass {
    @Override
    public int doSomething(int num) {
        System.out.println("方法执行中.....");
        return num;
    }
    
    @Override
    public int doSomethingElse(int i, int j) {
        return 0;
    }
    
    
}
