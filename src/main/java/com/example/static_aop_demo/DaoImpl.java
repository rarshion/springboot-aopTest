package com.example.static_aop_demo;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class DaoImpl implements Dao {
    @Override
    public void insert() {
        System.out.println("DaoImpl.insert()");
    }
}
