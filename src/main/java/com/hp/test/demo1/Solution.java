package com.hp.test.demo1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 进位方式计算，通过对10取模，得到应该设置的值和是否有进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 定义第一个节点
        ListNode target = null;
        // 定义下一个节点
        ListNode next = null;
        boolean l1Flag = true;
        boolean l2Flag = true;
        int carray = 0;
        //当 两个链表依旧有内容的时候，就循环
        while (l1Flag || l2Flag || carray == 1) {
            // 两个链表同时存在，各自取值加和
            if (l1Flag && l2Flag) {
                // 两个链表都存在
                int sum_ = l1.val + l2.val + carray;
                int current = 0;
                if (sum_ >= 10) {
                    current = sum_ % 10;
                    carray = 1;
                } else {
                    current = sum_;
                    carray = 0;
                }
                if (target == null) {
                    target = new ListNode();
                    target.setVal(current);
                    next = target;
                } else {
                    ListNode tmp = new ListNode();
                    tmp.setVal(current);
                    next.setNext(tmp);
                    next = tmp;
                }

                // 设置下一个获取值的节点
                l1 = l1.next;
                l2 = l2.next;
                if (l1 == null) {
                    l1Flag = false;
                }
                if (l2 == null) {
                    l2Flag = false;
                }
            } else if (l1Flag && !l2Flag) {
                // l1链表有数据
                int sum_ = l1.val + 0 + carray;
                int current = 0;
                if (sum_ >= 10) {
                    current = sum_ % 10;
                    carray = 1;
                } else {
                    current = sum_;
                    carray = 0;
                }
                // 对目标节点赋值
                if (target == null) {
                    target = new ListNode();
                    target.setVal(current);
                    next = target;
                } else {
                    ListNode tmp = new ListNode();
                    tmp.setVal(current);
                    next.setNext(tmp);
                    next = tmp;
                }

                // 设置下一个获取值的节点
                l1 = l1.next;
                if (l1 == null) {
                    l1Flag = false;
                }
            } else if (!l1Flag && l2Flag) {
                // l2链表有数据
                int sum_ = l2.val + 0 + carray;
                int current = 0;
                // 这里计算进位可以优化为  sum_ / 10 = carray
                if (sum_ >= 10) {
                    current = sum_ % 10;
                    carray = 1;
                } else {
                    current = sum_;
                    carray = 0;
                }
                if (target == null) {
                    target = new ListNode();
                    target.setVal(current);
                    next = target;
                } else {
                    ListNode tmp = new ListNode();
                    tmp.setVal(current);
                    next.setNext(tmp);
                    next = tmp;
                }

                // 设置下一个获取值的节点
                l2 = l2.next;
                if (l2 == null) {
                    l2Flag = false;
                }
            } else {
                //处理最后一个进位
                next.setNext(new ListNode(carray));
                carray = 0;
            }

        }
        return target;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        String num1Str = Solution.listNode(l1);
        String num2Str = Solution.listNode(l2);
        long l = Math.addExact(Long.parseLong(num1Str), Long.parseLong(num2Str));
        System.out.println(String.format("%s + %s = %d", num1Str, num2Str, l));
        String numStr = "" + l;

        int[] array = new int[numStr.length()];
        for (int i = numStr.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = numStr.charAt(i);
            array[j] = Integer.parseInt(c + "");
        }
        ListNode targetNode = Solution.assembleListNode(array);
        return targetNode;

    }


    public static void main(String[] args) {
        int[] arrays = {2, 4, 9, 2};
        ListNode listNode = Solution.assembleListNode(arrays);
        Solution.listNode(listNode);

        int[] arrays2 = {5, 6, 4};
        ListNode listNode2 = Solution.assembleListNode(arrays2);
        Solution.listNode(listNode2);

//        ListNode target = Solution.addTwoNumbers2(listNode, listNode2);
        ListNode target = Solution.addTwoNumbers1(listNode, listNode2);

        Solution.listNode(target);
    }

    /**
     * 遍历链表
     *
     * @param node
     */
    public static String listNode(ListNode node) {
        StringBuffer result = new StringBuffer();
        boolean flag = true;
        ListNode tmpNode = node;
        while (flag) {
            System.out.printf(tmpNode.getVal() + "-->");
            result.insert(0, tmpNode.val);
            if (tmpNode.getNext() != null) {
                tmpNode = tmpNode.getNext();
            } else {
                flag = false;
            }
        }
        System.out.println("");
        return result.toString();
    }

    /**
     * 根据数组组装列表
     *
     * @param arrays
     * @return
     */
    public static ListNode assembleListNode(int[] arrays) {
        ListNode last = null;
        for (int i = arrays.length - 1; i >= 0; i--) {
            int tmp = arrays[i];
            ListNode node = new ListNode();
            node.setVal(tmp);
            node.setNext(last);
            last = node;
        }
        System.out.println("***************");
        return last;
    }
}
