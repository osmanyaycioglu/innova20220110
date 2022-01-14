package com.training.spring;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncProjectApplication implements ApplicationRunner {

    public static void main(final String[] args) {
        SpringApplication.run(AsyncProjectApplication.class,
                              args);
    }

    @Async
    public Future<String> asyncMethod() {
        return CompletableFuture.completedFuture("Osman");
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        Future<String> asyncMethodLoc = this.asyncMethod();
        // .....
        String string2Loc = asyncMethodLoc.get(100,
                                               TimeUnit.MILLISECONDS);

        if (asyncMethodLoc.isDone()) {
            String stringLoc = asyncMethodLoc.get();
        }
    }


}
