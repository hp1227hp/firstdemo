package com.hp.test.designpattern.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BoxNode extends Node {

    private String content;

    private List<Node> list = new ArrayList<>();

    public BoxNode(String content) {
        this.content = content;
    }

    public void add(Node node) {
        this.list.add(node);
    }

    @Override
    void print() {
        System.out.println(content);
    }

}
