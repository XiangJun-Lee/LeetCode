package com.leetcode2022;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leelixiangjun
 * @date 2021/7/19 16:48
 */
public class MaxFrequency {

    //初始版本
    public int myMaxFrequency(int[] nums, int k) {
        int start = 0, end = 1, result = 1, length = nums.length;
        if (length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        while (end < length) {
            int create = (nums[end] - nums[end - 1]) * (end - start);
            if (create <= k) {
                end++;
                k -= create;
            } else {
                k += nums[end - 1] - nums[start];
                start++;
            }
            if (start == end) {
                end ++;
            }
            result = Math.max(result, (end - start));
        }
        return result;
    }

    // 根据题解优化
    public int maxFrequency(int[] nums, int k) {
        int left = 0, right = 1, result = 1, length = nums.length, total = 0;
        Arrays.sort(nums);
        for (; right < length; right++) {
            total += (nums[right] - nums[right - 1]) * (right - left);
            while (total > k) {
                total -= (nums[right] - nums[left]);
                left++;
            }
            result = Math.max(result, (right - left) + 1);
        }
        return result;
    }

    // 官方版本
    public int maxFrequencyReal(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    @Test
    public void test() {
        int[] num = new int[]{8, 8, 7, 5, 11, 11, 11, 11};
        System.out.println(maxFrequency(num, 1));
    }
}
