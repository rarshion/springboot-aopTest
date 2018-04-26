package com.example.chain_demo;

/**
 * Author : Martin
 * Date : 2018/4/20
 * Description :
 */
public class ConcreteHandler extends Handler {
    
    @Override
    public void handleRequest() {
        if(getSuccessor() != null) {
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理请求");
        }
    }
    
}
