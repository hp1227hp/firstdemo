package com.hp.test.tree;

import java.util.Stack;

public class Solution {

    /**
     * 前序遍历
     * 递归方式
     * 他的访问顺序是：根节点→左子树→右子树
     *
     * @param treeNode
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 先打印根节点
        System.out.println(treeNode.val);
        // 再遍历左树
        preOrder(treeNode.getLeft());
        // 再遍历右树
        preOrder(treeNode.getRight());
    }

    /**
     * 非递归方式 前序遍历
     *
     * @param treeNode
     */
    public void preOrder2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
        }
    }

    /**
     * 中序遍历
     * 左子树→根节点→右子树
     * 所以上图前序遍历的结果是：D→B→E→A→F→C
     *
     * @param treeNode 有点绕，没看明白
     */
    public static void inOrderTraversal(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.getLeft();
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.println(tree.val);
                tree = tree.getRight();
            }
        }
    }

    /**
     * DFS(深度优先搜索)
     * 他的访问顺序是：先访根节点，然后左结点，一直往下，直到最左结点没有子节点的时候然后往上退一步到父节点，然后父节点的右子节点在重复上面步骤……
     * 所以上图前序遍历的结果是：A→B→D→E→C→F
     *
     * @param treeNode
     */
    public void testDFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
        }
    }


    public void middleOrder2(TreeNode treeNode) {

    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        c.setLeft(f);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        a.setLeft(b);
        // 前序遍历tree
//        new Solution().preOrder(a);
//        new Solution().preOrder2(a);

        // 中序遍历
//        new Solution().inOrderTraversal(a);

        // 深度优先遍历
        new Solution().testDFS(a);
    }

}
