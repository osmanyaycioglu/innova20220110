package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class HelloWorldApplication {

    int             counter;

    @Autowired
    private MyBean  myBean1;

    @Autowired
    private MyBean  myBean2;

    @Autowired
    private AppProp ap;

    // @Scheduled(fixedDelay = 2_000, initialDelay = 2_000)
    public void hello() {
        this.myBean1.hello();
        this.myBean2.hello();
        // System.out.println("Hello world " + this.counter++ + " " + this.ap);
    }

    public static void main(final String[] args) {
        SpringApplication.run(HelloWorldApplication.class,
                              args);
    }

}
