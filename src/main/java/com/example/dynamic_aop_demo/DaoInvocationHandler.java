package com.example.dynamic_aop_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class DaoInvocationHandler implements InvocationHandler {
    
    private Object object;
    
    public DaoInvocationHandler(Object object) {
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName)) {
            Object result = method.invoke(object, args); //调用object的方法
            return result;
        }
        return method.invoke(object, args);
    }
    
}
