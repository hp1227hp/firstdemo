package com.hp.test.test;

import java.util.Deque;

public class MainTest {

    public static void main(String[] args) {
        int[] arrays = {1, 6, 7, 5, 3, 2, 5, 7, 1000};
//        int[] arrays = {1, 6, 7, 7};
        int l = 0;
        int r = arrays.length - 1;
        int ret = 0;
        while (l < r) {
            ret = Math.max(ret, Math.min(arrays[l], arrays[r]) * (r - l));
            if (arrays[l] > arrays[r]) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println("-----------------------");
        System.out.println(ret);
    }

}
