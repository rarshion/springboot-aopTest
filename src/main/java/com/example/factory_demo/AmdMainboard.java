package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class AmdMainboard implements Mainboard {
    
    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    
    @Override
    public void installCPU() {
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}
