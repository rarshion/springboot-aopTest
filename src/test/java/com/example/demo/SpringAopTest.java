package com.example.demo;

import com.example.demo.aspect.AopAdviceConfig;
import com.example.demo.aspect.BeforeAdvice;
import com.example.demo.service.TestAspectService;
import com.example.demo.service.TestAspectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;


@Slf4j
public class SpringAopTest {
    
    @Test
    public void testProxyFactory() {
        //1.创建代理工厂对象
        ProxyFactory factory = new ProxyFactory(new TestAspectServiceImpl());
        //2.添加advice拦截
        factory.addAdvice(new BeforeAdvice());
        //3.创建代理对象
        TestAspectService pojo = (TestAspectService) factory.getProxy();
        //4.方法调用
        pojo.beforeAdvice();
    }
    
    @Test
    public void testAspectJProxyFactory() {
        //1.手工创建一个实例
        TestAspectService testAspectService = new TestAspectServiceImpl();
        //2.使用AspectJ语法 自动创建代理对象
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(testAspectService);
        //3.添加切面和通知类
        aspectJProxyFactory.addAspect(AopAdviceConfig.class);
        //4.创建代理对象
        TestAspectService proxyService = aspectJProxyFactory.getProxy();
        //5.进行方法调用
        proxyService.beforeAdvice();
    }
    
}
