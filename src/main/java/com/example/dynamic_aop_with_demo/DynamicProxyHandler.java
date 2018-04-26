package com.example.dynamic_aop_with_demo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author : Martin
 * Date : 2018/4/19
 * Description :
 */
public class DynamicProxyHandler implements InvocationHandler {
    
    private Object proxied;
    
    /**
     * @param proxied 被代理对象
     */
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    
    /**
     * 返回代理对象
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(),
                proxied.getClass().getInterfaces(), this);
    }
    
    /**
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        addClassToDisk(proxy.getClass().getName(), ProxyClassImpl.class, "./$Proxy0.class");
        System.out.println("method:"+method.getName());
        System.out.println("args:"+args[0].getClass().getName());
        System.out.println("Before invoke method...");
        Object object = method.invoke(proxied, args);
        System.out.println("After invoke method...");
        return object;
    }
    
    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     */
    private void addClassToDisk(String className, Class<?> cl, String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}