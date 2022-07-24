package com.hp.test.binarytree;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TreeNode {

    private char val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(char data) {
        this.val = data;
    }

}
