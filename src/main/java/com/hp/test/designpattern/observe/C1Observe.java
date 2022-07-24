package com.hp.test.designpattern.observe;

public class C1Observe implements Observe {
    @Override
    public void action() {
        System.out.println("C1 因触发工作了");
    }
}
