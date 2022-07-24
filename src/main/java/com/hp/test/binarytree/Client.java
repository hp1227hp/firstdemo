package com.hp.test.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Client {

    public static TreeNode createTreeNode() {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        TreeNode h = new TreeNode('h');
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        e.setRight(h);
        return a;
    }

    /**
     * 二叉树的先序遍历
     * 通过递归方式很简单
     * 二叉树的先序遍历顺序为：根节点->左孩子->右孩子
     * a b d e h c f g
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getVal());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 中序遍历
     * 二叉树的中序遍历顺序为：左孩子->根节点->右孩子
     * DBEHAFCG
     * d b e h a f c g
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getVal());
            inOrder(root.getRight());
        }
    }

    /**
     * 后序遍历
     * 左 右 根
     * d h e b f g c a
     * DHEBFGCA
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getVal());
        }
    }

    /**
     * 求二叉树的节点个数
     * 节点个数 = 左子树节点数 + 右子树节点数 + 1
     *
     * @param root
     * @return
     */
    public static int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //root不为空
        int tmp = size2(root.getLeft()) + size2(root.getRight()) + 1;
        return tmp;
    }

    /**
     * 计算二叉树叶子节点个数
     * 子问题
     *
     * @param root
     * @return
     */
    public static int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (!(root.getLeft() == null && root.getRight() == null)) {
            int tmp = 0;
            tmp += getLeafNodeCount1(root.getLeft()) + getLeafNodeCount1(root.getRight());
            return tmp;
        } else {
            return 1;
        }
    }

    /**
     * 获取二叉树的高度
     * 要求出二叉树的高度，即求出左子树的高度，再求出右子树的高度，判断哪个高，
     * 如果左子树高，则左子树的高度+1即为该二叉树的高度.
     *
     * @param root
     * @return
     */
    public static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.getLeft());
        int rightHeight = getTreeHeight(root.getRight());
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    /**
     * 二叉树的查询
     * 二叉树的查询利用遍历的思想，以递归的方式实现，首先判断根节点的值是否为待查值，
     * 如果不是则依次访问左子树和右子树，如果找到，则返回该节点，如果未找到则返回null.
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.getVal() == val) {
            return root;
        }
        TreeNode target = find(root.getLeft(), val);
        if (target != null) {
            return target;
        }
        target = find(root.getRight(), val);
        if (target != null) {
            return target;
        } else {
            return null;
        }
    }

    /**
     * 构建二叉树
     * 递归方式，根据内部写法，所以是前序遍历方式
     * @param inputList 输入序列
     * @return node 返回根节点
     */
    public static TreeNode creatBinaryTree(LinkedList<Character> inputList){
        TreeNode node = null;
        if(inputList == null || inputList.isEmpty()){
            return null;
        }
        Character data = inputList.removeFirst(); //去除并返回LinkedList中的第一个元素
        if (data != null && !(data == ' ')){
            node = new TreeNode(data);
            node.setLeft(creatBinaryTree(inputList));
            node.setRight(creatBinaryTree(inputList));
        }
        return node;
    }

    /**
     * 二叉树 非递归的先序遍历
     * @param root
     */
    public static void preOrderNonRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.getVal() + "  ");
            if(pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if(pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
        }
    }

    /**
     * 非递归的中序遍历
     * @param root
     */
    public static void inOrderNonRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curso = root;
        while(curso != null || !stack.empty()) {
            while (curso != null) {
                stack.push(curso);
                curso = curso.getLeft();
            }
            curso = stack.pop();
            System.out.print("  " + curso.getVal());
            curso = curso.getRight();
        }

    }

    /**
     * 二叉树 非递归 后序遍历
     * @param root
     */
    public static void postOrderNonRecusive(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        TreeNode lastVisitedNode = root;
        while(cursor != null || !stack.empty()) {
            while(cursor !=null) {
                stack.push(cursor);
                cursor = cursor.getLeft();
            }
            TreeNode peekTopNode = stack.peek();
            if(peekTopNode.getRight() !=null &&
                    peekTopNode.getRight() != lastVisitedNode) {
                cursor = peekTopNode.getRight();
            } else {
                TreeNode topNode = stack.pop();
                System.out.print("  " + topNode.getVal());
                lastVisitedNode = topNode;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode rootTreeNode = Client.createTreeNode();
        // a b d e h c f g
        Client.preOrderNonRecursive(rootTreeNode);
        System.out.println();
        //d b e h a f c g
        Client.inOrderNonRecursive(rootTreeNode);
        System.out.println();
        // d h e b f g c a
        Client.postOrderNonRecusive(rootTreeNode);
        // 先序遍历
//        Client.preOrder(rootTreeNode);
        // 中序遍历
//        Client.inOrder(rootTreeNode);
        // 后序遍历
//        Client.postOrder(rootTreeNode);
        // 求二叉树节点个数
//        System.out.println(Client.size2(rootTreeNode));
//        int leafNodeCount1 = Client.getLeafNodeCount1(rootTreeNode);
//        System.out.println(leafNodeCount1);
        // 求树的高度
//        System.out.println(Client.getTreeHeight(rootTreeNode));

        // 在二叉树里查找元素
//        TreeNode h = Client.find(rootTreeNode, 'g');
//        System.out.println(h == null ? null : h.getVal());

//        LinkedList<Character> inputList = new LinkedList<Character>(
//                Arrays.asList(new Character[]{'3', '2', '9', ' ', ' ', 'a', ' ', ' ', '8', ' ', '4'})
//        );
//        TreeNode treeNode = creatBinaryTree(inputList);
//        System.out.println(treeNode);
    }


}
