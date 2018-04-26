package com.example.observer_demo;

/**
 * Author : Martin
 * Date : 2018/4/11
 * Description :
 */
public class HexaObserver extends Observer{
    
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
