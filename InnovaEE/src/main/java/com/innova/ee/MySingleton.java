package com.innova.ee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class MySingleton {

    public MySingleton() {
    }

    private int                 counter  = 0;
    private final List<Integer> integers = Collections.synchronizedList(new ArrayList<>());


    private synchronized int increase() {
        return this.counter++;
    }


    // @Lock(LockType.WRITE)
    public void hello1() {
        int increaseLoc = this.increase();
        this.integers.add(increaseLoc);
        System.out.println("Counter " + increaseLoc);
    }

    // @Lock(LockType.WRITE)
    public void hello2() {
        System.out.println("Counter " + this.increase());
    }

}
