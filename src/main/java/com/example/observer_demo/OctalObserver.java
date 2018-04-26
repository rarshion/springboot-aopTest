package com.example.observer_demo;

/**
 * Author : Martin
 * Date : 2018/4/11
 * Description :
 */
public class OctalObserver extends Observer{
    
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}