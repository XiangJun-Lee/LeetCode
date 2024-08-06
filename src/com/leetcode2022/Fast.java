package com.leetcode2022;

import org.junit.Test;

public class Fast {

    private int[] check(int[] nums, int start, int end) {
        if(start>end){
            return nums;
        }
        int left=start,right=end;
        int target = nums[start];
        while (left<right){
            while (target<=nums[right]&&left<right){
                right--;
            }
            while (target>=nums[left]&&left<right){
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = target;
        check(nums,start,right-1);
        check(nums,right+1,end);
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {2,1,5,9,10,6};
        int[] res = check(nums,0,nums.length-1);
        for(int n: res){
            System.out.print(n+",");
        }
    }

    @Test
    public void test1(){
        new threadThree().start();
        new threadTwo().start();
        new threadOne().start();
    }
}
