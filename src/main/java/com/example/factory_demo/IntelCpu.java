package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class IntelCpu implements Cpu {
    
    private int pins = 0;
    
    public  IntelCpu(int pins){
        this.pins = pins;
    }
    
    @Override
    public void calculate() {
        System.out.println("Intel CPU的针脚数：" + pins);
    }

}
