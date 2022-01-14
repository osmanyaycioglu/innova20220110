package com.training.spring.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.training.spring.MyBean;
import com.training.spring.aop.MyIntercept;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//@Configuration
//@Controller
//@Repository
//@Service

// @RequestScope
// @SessionScope
@ApplicationScope
@RestController
@RequestMapping("/rest/first")
public class MyFirstRest {

    @Autowired
    private MyBean         mb;

    @Autowired
    private RabbitTemplate rt;

    @MyIntercept("Hello rest testi")
    @GetMapping("/hello")
    @Operation(description = "hello world description")
    @ApiResponse(responseCode = "600", description = "Dönebilir")
    public String hello() {
        this.mb.hello();
        return "Hello world";
    }

    @GetMapping("/send/sms")
    public String testQueue(@RequestParam("msg") final String str) {
        this.rt.convertAndSend("message-exchenage",
                               "sms-send",
                               str);
        return "OK";
    }

}
