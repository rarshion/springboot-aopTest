package com.example.demo.controller;

import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SimpleService simpleService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/add")
    public String add() {
        System.out.println("test");
        return "add success aaa";
    }

    @RequestMapping("/findAll")
    public String findAll(){
        simpleService.findAll();
        return "findAll";
    }
}
