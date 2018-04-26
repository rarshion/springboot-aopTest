package com.example.dynamic_aop_with_demo;

/**
 * Author : Martin
 * Date : 2018/4/19
 * Description :
 */
public class SimpleProxyDemo {
    public static void main(String[] args) throws SecurityException {
        ProxyClassImpl c = new ProxyClassImpl();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(c);
        IProxyClass proxyClass = (IProxyClass)proxyHandler.newProxyInstance();
        System.out.println(proxyClass.getClass().getName());
        System.out.println(proxyClass.doSomething(5));
    }
}
