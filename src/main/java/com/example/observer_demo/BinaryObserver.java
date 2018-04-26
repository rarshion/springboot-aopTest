package com.example.observer_demo;

/**
 * Author : Martin
 * Date : 2018/4/11
 * Description :
 */
public class BinaryObserver extends Observer {
    
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}
