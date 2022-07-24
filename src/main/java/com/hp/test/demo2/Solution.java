package com.hp.test.demo2;

public class Solution {

    public int[] towSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i, k = j + 1; k <= nums.length - 1; k++) {
                if (nums[j] + nums[k] == target) {
                    return new int[]{j, k};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 4, 7, 9, 10, 13};
        int target = 2;
        Solution solution = new Solution();
        int[] indexs = solution.towSum(nums, target);
        for (int index : indexs) {
            System.out.printf(index + "  ");
        }
    }
}
