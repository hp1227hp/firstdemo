package com.hp.test.mergearryandsort;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        int[] a = {19,30,0,3,5,6,7};
        Client.sortArray(a);
        System.out.println(Arrays.toString(a));
        int[] b = new int[]{-10, -9, -3, 9};
        int[] sortArray = Client.mergeAndSort(a, b);
        System.out.println("-----------------------");

        Arrays.stream(sortArray).forEach(System.out::println);
    }


    public static void sortArray(int[] array) {
        for(int i = 0; i< array.length; i++) {
            for(int j = 0; j< array.length; j++) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 此方法是针对两个排好序的数组，进行合并排序
     * 重点：两个数组已经排好序了
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeAndSort(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[index] = a[i];
                i++;
                index++;
            } else {
                result[index] = b[j];
                j++;
                index++;
            }
        }
        while (i >= a.length && j < b.length) {
            result[index++] = b[j++];
        }
        while (i < a.length && j >= b.length) {
            result[index++] = a[i++];
        }
        return result;
    }

}
