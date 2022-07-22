package com.hp.test.mergearryandsort;

import java.util.Arrays;
import java.util.LinkedList;

public class Client2 {

    public static void method1(int a[],int b[],int array[]) {


        //建立c数组，并将a添加进去
        int c[]= Arrays.copyOf(a, a.length+b.length);
        //将b数组添加到已经含有a数组的c数组中去
        System.arraycopy(b, 0, c, a.length, b.length);
        //对c数组进行排序
        Arrays.sort(c);
        System.out.println("方法一：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+" ");
        }
    }

    //方法二:集合方法  使用LinkedList 队列
    public static void method2(int array[], LinkedList<Integer> queue_a, LinkedList<Integer> queue_b ) {
        //每循环一次，添加一个最小元素进入arrays
        for (int i = 0; i < array.length; i++) {
            //两个队列都不为空时，谁小取出谁
            if (!queue_a.isEmpty()&&!queue_b.isEmpty()) {
                if (queue_a.peek()<queue_b.peek()) {
                    array[i]=queue_a.poll();
                    continue;
                }else {
                    array[i]=queue_b.poll();
                    continue;
                }
            }
            //当数组a为空时，取数组b的元素
            if (queue_a.isEmpty()&&!queue_b.isEmpty()) {
                array[i]=queue_b.poll();
                continue;
            }
            //当数组b为空时，取数组a的元素
            if (queue_b.isEmpty()&&!queue_a.isEmpty()) {
                array[i]=queue_a.poll();
                continue;
            }
        }
        System.out.println("方法二：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
