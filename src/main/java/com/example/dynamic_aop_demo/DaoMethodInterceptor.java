package com.example.dynamic_aop_demo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class DaoMethodInterceptor implements MethodInterceptor {
   
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            proxy.invokeSuper(object, objects);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
            return object;
        }
        proxy.invokeSuper(object, objects);
        return object;
    }
}
