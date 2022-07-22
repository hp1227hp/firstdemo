package com.hp.test.designpattern.composite;

public class Client {

    public static void main(String[] args) {
        Node root = new BoxNode("root");
        Node subN1 = new BoxNode("sub-n1");
        Node subN2 = new LeafNode("sub-leaf-n2");
        ((BoxNode) root).add(subN1);
        ((BoxNode) root).add(subN2);
        Node subL2 = new LeafNode("sub-n1-leaf-n2");
        Node subL3 = new LeafNode("sub-n1-leaf-n2");
        ((BoxNode) subN1).add(subL2);
        ((BoxNode) subN1).add(subL3);

        System.out.println("------------------------------------");

        tree(root, 1);

    }

    static void tree(Node node, int depth) {
        for (int i = 0; i <= depth; i++) System.out.print("---");
        node.print();
        if (node instanceof BoxNode) {
            for (Node n : ((BoxNode) node).getList()) {
                tree(n, depth + 2);
            }
        }
    }

}
