package com.innova.ee;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyStateful
 */
@Stateful
@LocalBean
public class MyStateful {

    public MyStateful() {
    }

    private int counter = 0;


    public void hello1() {
        System.out.println("Counter " + this.counter++);
    }

    public void hello2() {
        System.out.println("Counter " + this.counter++);
    }

    @Remove
    public void name() {

    }

    @PrePassivate
    public void prePasivate() {

    }

    @PostActivate
    public void posta() {

    }

}
