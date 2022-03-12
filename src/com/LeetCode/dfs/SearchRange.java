package com.LeetCode.dfs;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/10 10:34 上午
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (nums.length - 1) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
            }
        }
        return new int[]{-1, -1};
    }

}
