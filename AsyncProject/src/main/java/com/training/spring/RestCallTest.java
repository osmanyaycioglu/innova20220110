package com.training.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestCallTest {

    public void restCall(final Customer customerParam) {
        WebClient createLoc = WebClient.create("http://127.0.0.1:9090/api/v1/customer/provision/add");
        createLoc.post()
                 .bodyValue(createLoc)
                 .exchange()
                 .doOnSuccess(r -> {
                     Mono<String> bodyToMonoLoc = r.bodyToMono(String.class);
                     System.out.println(bodyToMonoLoc);
                 });
    }

}
