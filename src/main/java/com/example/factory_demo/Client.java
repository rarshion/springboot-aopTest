package com.example.factory_demo;

/**
 * Author : Martin
 * Date : 2018/4/9
 * Description :
 */
public class Client {
    public static void main(String[]args) {
//        ComputerEngineer cf = new ComputerEngineer();
//        cf.makeComputer(1,1);
    
        ComputerEngineer cf = new ComputerEngineer();
        AbstractFactory af = new IntelFactory();
        cf.makeComputer(af);
    }
}
