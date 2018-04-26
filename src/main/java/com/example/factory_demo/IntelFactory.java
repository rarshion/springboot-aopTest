package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class IntelFactory implements AbstractFactory {
    
    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }
    
    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
    
}
