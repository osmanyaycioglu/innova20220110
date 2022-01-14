package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private Caller ca;


    @Override
    public void run(final String... argsParam) throws Exception {
        for (int iLoc = 0; iLoc < 1; iLoc++) {
            System.out.println(this.ca.testHello("osman"));
        }
    }

}
