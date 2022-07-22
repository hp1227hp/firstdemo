package com.hp.test.reversesinglelink;

public class Client {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(node1);

        System.out.println(node3);

        System.out.println(getTail(node1));

//        Node newNode = deleteElement(node1, 5);

        deleteElement2(node1, 4);
//        Node newNode = reverseNode(node1);
//        Node newNode = reverseNode2(node1);
//        Node newNode = headReverse(node1);
        System.out.println("22222222");
    }

    public static Node getTail(Node node) {
        if (node == null) {
            return null;
        }
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    public static Node reverseNode(Node node) {
        Node head = node;
        Node current = head.getNext();
        Node next = null;
        head.setNext(null);
        while (current != null) {
            next = current.getNext();
            current.setNext(head);
            head = current;
            current = next;
        }
        return head;
    }

    /**
     * 原地倒转
     *
     * @param node
     * @return
     */
    public static Node reverseNode2(Node node) {
        if (node == null) {
            return null;
        }
        Node head = node;
        Node next = node.getNext();
        Node temp = null;
        head.setNext(null);
        while (next != null) {
            temp = next.getNext();
            next.setNext(head);
            head = next;
            next = temp;
        }
        return head;
    }

    /**
     * 新建一个链表头，采用头插法
     *
     * @param node
     * @return
     */
    public static Node headReverse(Node node) {
        Node head = new Node(-1);
        Node temp = null;
        while (node != null) {
            temp = node.getNext();
            node.setNext(head.getNext());
            head.setNext(node);
            node = temp;
        }
        return head.getNext();
    }

    /**
     * 单链表删除节点
     *
     * @param node
     * @param e
     */
    public static Node deleteElement(Node node, int e) {
        Node newRootNode = node;
        if (newRootNode == null) {
            return null;
        }
        if (newRootNode.getVal() == e) {
            return newRootNode.getNext();
        }
        Node pre = node;
        Node current = node.getNext();
        Node temp = null;
        while (current != null) {
            temp = current.getNext();
            if (current.getVal() == e) {
                pre.setNext(current.getNext());
                break;
            } else {
                pre = current;
                current = temp;
            }
        }
        return newRootNode;
    }

    public static Node deleteElement2(Node node, int e) {
        Node temp = new Node(-1, node);
        Node newRoot = temp;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getVal() == e) {
                flag = true;
                break;
            } else {
                temp = temp.getNext();
            }
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        }
        return newRoot.getNext();
    }


}


class Node {

    private int val;

    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return " " + this.val;
        } else {
            return " " + this.val + "-->" + this.getNext().toString();
        }
    }
}