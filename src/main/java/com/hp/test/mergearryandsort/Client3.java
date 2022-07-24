package com.hp.test.mergearryandsort;

import java.util.Arrays;
import java.util.Comparator;

public class Client3 {

    public static void main(String[] args) {
        int[] a = {3, 1, 6, 2, -4};
        int[] b = new int[]{-999, 999, 3, 1, 9, 4};
        int[] c = Arrays.copyOf(a, a.length + b.length);
        System.out.println(Arrays.toString(c));
        System.arraycopy(b, 0, c, a.length, b.length);
//        Arrays.sort(c);
//        System.out.println(Arrays.toString(c));

        // 使用Arrays.sort + Comparator 排序
        Integer[] integers = Arrays.stream(c).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });
        System.out.println(Arrays.toString(integers));

    }

}
