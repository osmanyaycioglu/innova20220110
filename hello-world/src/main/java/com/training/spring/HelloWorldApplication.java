package com.training.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRabbit
@ServletComponentScan
public class HelloWorldApplication {

    int             counter;

    @Autowired
    private MyBean  myBean1;

    @Autowired
    private MyBean  myBean2;

    @Autowired
    private AppProp ap;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

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
