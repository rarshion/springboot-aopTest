package com.example.static_aop_demo;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class ServiceImpl {
    
    private Dao dao = new DaoImpl();
    
    public void insert() {
        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.insert();
        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
    }
}
