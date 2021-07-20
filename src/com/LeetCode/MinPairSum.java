package com.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leelixiangjun
 * @date 2021/7/20 10:49
 */
public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length, res = 0;
        for (int i = 0; i < length/2; i++) {
            res = Math.max(res, nums[i]+nums[length-1-i]);
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = new int[]{3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }
}
