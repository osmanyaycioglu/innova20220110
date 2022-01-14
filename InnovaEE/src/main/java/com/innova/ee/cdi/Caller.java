package com.innova.ee.cdi;

import javax.inject.Inject;

public class Caller {

    @Inject
    private Callee callee;

    public String testHello() {
        return this.callee.hello();
    }

}
