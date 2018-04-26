package com.example.observer_demo;

/**
 * Author : Martin
 * Date : 2018/4/11
 * Description :
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
