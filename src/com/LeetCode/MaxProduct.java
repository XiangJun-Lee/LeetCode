package com.LeetCode;

import org.junit.Test;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int[] dp = new int[length];
        dp[0]=nums[0];
        int result = dp[0];
        for(int i=1;i<length;i++){
            int temp = dp[i-1]*nums[i];
            if(temp>=0&&dp[i-1]!=0){
                dp[i] = temp;
            }else if(temp<0){
                dp[i] = nums[i];
            }else {
                if(nums[i]>=0){
                    dp[i] = nums[i];
                }else {
                    dp[i] = temp;
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums = {0,2};
        System.out.println(maxProduct(nums));
    }
}
