package com.hp.test.bubblesort;

public class Solution {

    /**
     * 冒泡排序
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        int loopCount = 0;
        for (int i = 0; i <= nums.length - 2 - loopCount; i++) {
            for (int j = 0; j <= nums.length - 2 - loopCount; j++) {
                int a = nums[j];
                int b = nums[j + 1];
                if (a > b) {
                    swap(nums, j, j + 1);
                }
            }
            loopCount++;
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
//        int[] nums = {1,0,1,4,7,9,10,13};
        int[] nums = {4, 13, -7, 6, 3, 4};
        Solution solution = new Solution();
        int[] bubbleSort = solution.bubbleSort(nums);
        for (int i : bubbleSort) {
            System.out.printf(i + " ");
        }
    }
}
