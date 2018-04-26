package com.example.demo.config;

import com.example.demo.aspect.BeforeAdvice;
import com.example.demo.service.SimpleService;
import com.example.demo.service.SimpleServiceImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {
    
//    @Bean
//    public TokenInterceptor tokenInterceptor() {
//        return new TokenInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//
//    @Bean
//    public BeforeAdvice retryAdvice(){
//        return new BeforeAdvice();
//    }
//
//    @Bean
//    public JdkRegexpMethodPointcut regexPointcut(){
//        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//        pointcut.setPattern(".find*");
//        return pointcut;
//    }
//
//    @Bean
//    public DefaultPointcutAdvisor pointcutAdvisor(JdkRegexpMethodPointcut jdkRegexpMethodPointcut,BeforeAdvice retryAdvice){
//        return new DefaultPointcutAdvisor(jdkRegexpMethodPointcut, retryAdvice);
//    }
//
//    @Bean
//    public SimpleService createProxyFactory(DefaultPointcutAdvisor pointcutAdvisor){
//        ProxyFactory proxyFactory = new ProxyFactory(new SimpleServiceImpl());
//        proxyFactory.addInterface(SimpleService.class);
//        proxyFactory.addAdvisor(pointcutAdvisor);
//        proxyFactory.setExposeProxy(true);
//        return (SimpleService) proxyFactory.getProxy();
//    }
}
