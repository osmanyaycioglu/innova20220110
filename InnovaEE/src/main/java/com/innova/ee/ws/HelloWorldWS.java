package com.innova.ee.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloWorldWS {


    public String hello(@WebParam(name = "name") final String name) {
        return "Hello " + name;
    }

}
