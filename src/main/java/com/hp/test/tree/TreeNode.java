package com.hp.test.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode<T> {

    T val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode() {

    }

    public TreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }

}
