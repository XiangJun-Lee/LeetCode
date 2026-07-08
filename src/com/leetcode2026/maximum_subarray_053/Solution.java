package com.leetcode2026.maximum_subarray_053;

public class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            // 解题心得：判断是当前这个数更大 还是当前的数+它前面的连续的数更大。
            current = Math.max(value, current + value);
            best = Math.max(current, best);
        }
        return best;
    }
}
