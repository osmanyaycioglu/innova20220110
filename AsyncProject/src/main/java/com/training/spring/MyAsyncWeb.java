package com.training.spring;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/async")
public class MyAsyncWeb {

    private ICustomerDao cd;

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello world");
    }

    @GetMapping(value = "/hellos", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> hellos() {
        Flux<Customer> findByNameLoc = this.cd.findByName("osman");
        findByNameLoc.List<String> asListLoc = Arrays.asList("hello 1",
                                                             "hello2");
        return Flux.fromIterable(asListLoc);
    }


}
