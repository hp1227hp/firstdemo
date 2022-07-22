package com.hp.test.designpattern.observe;

public class Client {

    public static void main(String[] args) {
        Coffee coffee = new ACoffee();
        coffee.addObserv(new C1Observe());
        coffee.addObserv(new C2Observe());
        coffee.addObserv(() -> {
            System.out.println("被触发");
        });
        coffee.nofity();
    }

}
