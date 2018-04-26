package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public interface AbstractFactory {
    Cpu createCpu();
    
    Mainboard createMainboard();
}
