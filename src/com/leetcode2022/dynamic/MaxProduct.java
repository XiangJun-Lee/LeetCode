package com.leetcode2022.dynamic;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/8 9:23 下午
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
        for (int num : nums) {
            iMax = Math.max((num < 0 ? iMin : iMax) * num, num);
            iMin = Math.min((num < 0 ? iMax : iMin) * num, num);
            max = Math.max(max, iMax);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {-4, -3, -2};
        System.out.println(maxProduct(nums));
    }
}
