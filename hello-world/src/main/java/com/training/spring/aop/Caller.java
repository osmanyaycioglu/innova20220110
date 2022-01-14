package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {

    @Autowired
    private Callee callee;

    @MyIntercept("Buranın arasına girdim")
    public String testHello(final String name) {
        return this.callee.hello(name);
    }

}
