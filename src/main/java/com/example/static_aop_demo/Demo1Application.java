package com.example.static_aop_demo;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class Demo1Application {
    public static void main(String[] args) {
//        ServiceImpl service = new ServiceImpl();
//        service.insert();
//        service.delete();
//        service.update();
        
        //装饰器模式
        Dao dao = new DaoImpl();
        LogDao logDao = new LogDao(dao);
        logDao.insert();
    }
}
