package com.innova.ee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class MyStateless {

    private int counter = 0;

    public MyStateless() {
    }

    public void hello1() {
        System.out.println("Counter " + this.counter++);
    }

    public void hello2() {
        System.out.println("Counter " + this.counter++);
    }

}
