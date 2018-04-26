package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class AmdFactory implements AbstractFactory {
    
    @Override
    public Cpu createCpu() {
        return new IntelCpu(938);
    }
    
    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(938);
    }
    
}
