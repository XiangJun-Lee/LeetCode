package com.LeetCode.dynamic;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/5 10:51 下午
 */
public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, index = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (end >= n - 1) {
                return ans;
            }
            index = Math.max(index, i + nums[i]);
            if (i == end) {
                end = index;
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
