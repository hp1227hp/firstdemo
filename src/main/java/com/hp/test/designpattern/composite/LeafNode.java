package com.hp.test.designpattern.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeafNode extends Node {

    private String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    void print() {
        System.out.println(content);
    }

}
