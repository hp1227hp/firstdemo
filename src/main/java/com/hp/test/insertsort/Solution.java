package com.hp.test.insertsort;

public class Solution {

    /**
     * 插入排序
     * 数组分为排好序和未排好序两部分
     * 从第二个元素获取，和排好序的所有元素对比，找到合适位置插入
     * 然后继续遍历下一个待排序的元素，和已经排好序的元素找位置，插入
     * 直到没有元素了
     *
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1, k = i; j >= 0; j--) {
                if (nums[k] < nums[j]) {
                    int temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                    k = j;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 4, 7, 9, 10, 13};
//        int[] nums = {4, 13, -7, 6, 3, 4};
        Solution solution = new Solution();
        int[] bubbleSort = solution.insertSort(nums);
        for (int i : bubbleSort) {
            System.out.printf(i + " ");
        }
    }
}
