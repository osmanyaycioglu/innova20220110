package com.innova.ee.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.innova.ee.MySingleton;
import com.innova.ee.MyStateful;
import com.innova.ee.MyStateless;
import com.innova.ee.cdi.Caller;


@RequestScoped
@Path("/first")
@Produces({
            "application/json"
})
@Consumes({
            "application/json"
})
public class MyFirstRest {

    @EJB
    private MyStateless ms;

    @EJB
    private MyStateful  mStateful;

    @EJB
    private MySingleton mySingleton;

    @Inject
    private Caller      caller;

    @Path("/hello")
    @GET
    public String helloWorld1() {
        this.ms.hello1();
        this.ms.hello2();
        return "Hello world";
    }

    @Path("/hello2")
    @GET
    public String helloWorld2() {
        this.mStateful.hello1();
        this.mStateful.hello2();
        return "Hello world";
    }

    @Path("/hello3")
    @GET
    public String helloWorld3() {
        this.mySingleton.hello1();
        this.mySingleton.hello2();
        return "Hello world";
    }

    @Path("/hello4")
    @GET
    public String helloWorld4() {
        return this.caller.testHello();
    }

}
