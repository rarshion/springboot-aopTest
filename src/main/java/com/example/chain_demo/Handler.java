package com.example.chain_demo;

/**
 * Author : Martin
 * Date : 2018/4/20
 * Description :
 */
public abstract class Handler {
    protected Handler successor;
    
    public abstract void handleRequest();
    
    
    public Handler getSuccessor() {
        return successor;
    }
    
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
