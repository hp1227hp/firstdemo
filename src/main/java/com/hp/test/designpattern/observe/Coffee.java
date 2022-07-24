package com.hp.test.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

public abstract class Coffee {

    private List<Observe> list = new ArrayList<>();

    public void addObserv(Observe observe) {
        list.add(observe);
    }

    public List<Observe> getList() {
        return list;
    }

    public abstract void nofity();

}
