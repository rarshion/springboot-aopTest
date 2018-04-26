package com.example.dynamic_aop_demo;

import com.example.static_aop_demo.Dao;
import com.example.static_aop_demo.DaoImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :J
 *
 *
 * DK提供的动态代理只能针对接口做代理，不能针对类做代理
 * 代码依然有耦合，如果要对delete方法调用前后打印时间，得在LogInvocationHandler中增加delete方法的判断
 */
public class DynamicApplication {
    public static void main(String[] args) {
    
    //设置此系统属性,让JVM生成的Proxy类写入文件
    //System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    //设置将cglib生成的代理类字节码生成到指定位置
    //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./$Proxy1.class");
        
        //1.jdk proxy
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Dao dao = new DaoImpl();
        Dao proxyDao = (Dao) Proxy.newProxyInstance(
                DaoInvocationHandler.class.getClassLoader(),
                new Class[]{Dao.class},
                new DaoInvocationHandler(null));
        proxyDao.insert();

        //2.cglib
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./$DaoProxy.class");
//        DaoMethodInterceptor daoProxy = new DaoMethodInterceptor();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(DaoImpl.class);
//        enhancer.setCallback(daoProxy);
//        Dao dao = (DaoImpl)enhancer.create();
//        dao.insert();
    }
}
