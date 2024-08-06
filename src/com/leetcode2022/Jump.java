package com.leetcode2022;

import org.junit.Test;

public class Jump {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len<=1){
            return 0;
        }
        int[] jumpTimes = new int[len];
        for(int i=0;i<len;i++){
            int num = nums[i];
            for(int j=1;j<=num;j++){
                int cur = jumpTimes[i+j];
                if(cur==0){
                    jumpTimes[i+j]=jumpTimes[i]+1;
                }else {
                    jumpTimes[i+j] = jumpTimes[i]+1<cur? jumpTimes[i]+1:cur;
                }
                if(i+j==len-1){
                    return jumpTimes[len-1];
                }
            }
        }
        return jumpTimes[len-1];
    }

    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
