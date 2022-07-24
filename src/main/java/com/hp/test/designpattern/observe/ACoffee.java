package com.hp.test.designpattern.observe;

public class ACoffee extends Coffee {
    @Override
    public void nofity() {
        System.out.println("触发动作");
        this.getList().stream().forEach(Observe::action);
    }
}
