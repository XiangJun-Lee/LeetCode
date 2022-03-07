package com.LeetCode.Dynamic;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/5 4:27 下午
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }


    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
