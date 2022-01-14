package com.training.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Callee {

    public String hello(final String name) {
        System.out.println("Callee Hello Method");
        return "hello " + name;
    }

}
