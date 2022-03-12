package com.LeetCode.dynamic;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/7 15:16
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int maxPre = 0, maxAns = nums[0], minPre = 0, minAns = nums[0], total = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            maxPre = Math.max(maxPre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, maxPre);
            minPre = Math.min(minPre + nums[i], nums[i]);
            minAns = Math.min(minAns, minPre);
            total += nums[i];
        }
        return maxAns > 0 ? Math.max(maxAns, total - minAns) : maxAns;
    }

    @Test
    public void test() {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
