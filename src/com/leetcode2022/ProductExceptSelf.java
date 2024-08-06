package com.leetcode2022;

import org.junit.Test;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length,R = 1;
        int[] result = new int[length];
        result[0] = 1;
        for(int i=1;i<length;i++){
            result[i] = nums[i-1]*result[i-1];
        }
        for(int i=length-2;i>=0;i--){
            R *=nums[i+1];
            result[i]*=R;
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums={1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
}
