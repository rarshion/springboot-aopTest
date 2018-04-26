package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class AmdCpu implements Cpu {

    private int pins = 0;
    
    public  AmdCpu(int pins){
        this.pins = pins;
    }
    
    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
