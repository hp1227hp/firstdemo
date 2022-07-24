package com.hp.test.designpattern.observe;

public class C2Observe implements Observe {
    @Override
    public void action() {
        System.out.println("C2 因触发工作了");
    }
}
