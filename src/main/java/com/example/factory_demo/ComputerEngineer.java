package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class ComputerEngineer {
    
    private Cpu cpu = null;
    private Mainboard mainboard = null;

    public void makeComputer(int cpuType , int mainboard){
        prepareHardwares(cpuType, mainboard);
    }
    
    public void makeComputer(AbstractFactory af){
        prepareHardwares(af);
    }
    
    private void prepareHardwares(int cpuType , int mainboard){
        this.cpu = CpuFactory.createCpu(cpuType);
        this.mainboard = MainboardFactory.createMainboard(mainboard);
        this.cpu.calculate();
        this.mainboard.installCPU();
    }

    private void prepareHardwares(AbstractFactory af){
        this.cpu = af.createCpu();
        this.mainboard = af.createMainboard();
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
