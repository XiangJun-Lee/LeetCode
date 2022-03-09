package com.LeetCode.Dynamic;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/8 9:51 下午
 */
public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        int leftP = nums.length, leftN = nums.length, rightP = -1,rightN = -1, ans = 0,curMult=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ans = Math.max(ans,Math.max((rightP-leftP),(rightN-leftP)));
                leftP = nums.length;
                leftN = nums.length; rightP = -1;
                rightN = -1;
                curMult=1;
                continue;
            }
            curMult*=nums[i];
            if(curMult>0){
                leftP = Math.min(leftP,i);
                rightP = i;
                continue;
            }
            if(curMult<0){
                leftN = Math.min(leftN,i);
                rightN = i;
            }
        }
        return Math.max(ans,Math.max((rightP-leftP),(rightN-leftP)))+1;
    }

    @Test
    public void test(){
        int[] nums = {-1,2};
        System.out.println(getMaxLen(nums));
    }
}
