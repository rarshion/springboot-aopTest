package com.example.chain_demo;

/**
 * Author : Martin
 * Date : 2018/4/20
 * Description :
 */
public class ChainApplication {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        handler1.handleRequest();
    }
}
