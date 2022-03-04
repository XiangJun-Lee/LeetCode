package com.LeetCode.March;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/4 10:27
 * @num 2104
 */
public class March4 {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
            for (int j = i; j < len; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }

    @Test

    public void test() {
        int[] nums = {4, -2, -3, 4, 1};
        System.out.println(subArrayRanges(nums));
    }
}
