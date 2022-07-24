package com.hp.test.designpattern.singleton.prototype;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Car implements Cloneable {
    private Integer id;
    private String color;
    private String name;

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}