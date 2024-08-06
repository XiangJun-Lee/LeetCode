package com.leetcode2022.March;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/9 3:47 下午
 */
public class March9 {
    public int bestRotation(int[] nums) {
        int[] delta = new int[nums.length];
        int ans = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            delta[i] = i - nums[i];
            if (delta[i] >= 0) {
                max++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int curMax = 0;
            for (int j = 0; j < nums.length; j++) {
                delta[j] = (delta[j] - 1) + (i == j ? nums.length : 0);
                if (delta[j] >= 0) {
                    curMax++;
                }
            }
            if (curMax > max) {
                max = curMax;
                ans = i+1;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 0, 2, 4};
        System.out.println(bestRotation(nums));
    }
}
