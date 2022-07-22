package com.hp.test.selectsort;

public class Solution {

    /**
     * 选择排序
     * 从数组第一个开始，和后续所有的元素对比，将最小的元素放到第一位   第一个元素已经排好了
     * 再从数据第二个元素，和后续所有元素对比，将最小的元素放到第二位， 第二个元素已经排好了
     *
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
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
//        int[] nums = {1,0,1,4,7,9,10,13};
        int[] nums = {4, 13, -7, 6};
        Solution solution = new Solution();
        int[] bubbleSort = solution.selectSort(nums);
        for (int i : bubbleSort) {
            System.out.printf(i + " ");
        }
    }
}
