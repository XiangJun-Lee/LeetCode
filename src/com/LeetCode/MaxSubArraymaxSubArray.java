package com.LeetCode;

import org.junit.Test;

import java.util.ArrayList;

public class MaxSubArraymaxSubArray {
    public int maxSubArray(int[] nums) {
        int length =nums.length;
        if(length==0){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i=1;i<length;i++){
            if(dp[i-1]>=0){
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums = {-2,-1,-3};
        System.out.println(maxSubArray(nums));
    }
}
