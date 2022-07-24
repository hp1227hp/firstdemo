package com.hp.test.link;

import org.springframework.util.StringUtils;

public class Client {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        list.addTail(9);
        System.out.println(list.getHead());

        list.addTail2(10);
        System.out.println(list.getHead());
        System.out.println("-----------------");
        System.out.println(list);
        System.out.println("---------------------------------------");
        list.addIndex(0,99);
        System.out.println(list);
        System.out.println("----------");
        Node temp = null;
        System.out.println((temp = list.get(4)) == null ? "" : temp.val);
        System.out.println("----------------");
        System.out.println(list.contains(99));
        System.out.println("-----");
        list.set(0, 999);
        System.out.println(list);
        System.out.println("##################");
        System.out.println(list.removeIndex(1).val);
        System.out.println(list);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Node x = list.removeFirst();
        System.out.println(x);
        System.out.println(list);
        Node node = list.removeLast();
        System.out.println(node.val);
        System.out.println(list);
        System.out.println("&&&&&&&&&&&&&&&&&&");
        list.addFirst(18);
        list.addTail(30);
        System.out.println(list);
        Node re = list.removeValueOnce(18);
        System.out.println(re.val);
        System.out.println(list);
        Node node1 = list.removeValueOnce(200);
        System.out.println(node1 == null);
        System.out.println(list);
        Node node2 = list.removeValueOnce(30);
        System.out.println(node2.val);
        System.out.println(list);
        list.addTail(898);
        list.addTail(765);
        System.out.println(list);
        list.removeValueOnce2(1);
        System.out.println(list);
        list.addFirst(18);
        list.addFirst(19);
        list.addFirst(20);
        list.addTail(20);
        list.addFirst(20);
        list.addIndex(3, 20);
        System.out.println(list);
        list.removeValueAll2(20);
        System.out.println(list);
        list.addFirst(20);
        list.addTail(20);
        list.addFirst(20);
        list.addIndex(3, 20);
        System.out.println(list);
        list.removeValueAll(20);
        System.out.println(list);
    }

}
