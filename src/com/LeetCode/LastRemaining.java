package com.LeetCode;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class LastRemaining {
    public static int lastRemaining(int n, int m) {
        if(n<=1){
            return n;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        int next= m-1;
        for(int i=0;i<n;i++){
            nums.add(i);
        }
        while(nums.size()>1){
            next%=nums.size();
            nums.remove(next);
            next+=m-1;
        }
        return nums.get(0);
    }
    public static int lastRemaining1(int n, int m){
        if(n<=1){
            return n;
        }
        int next = 0;
        int[] nums = new int[n];
        for(int i=0;i<n-1;i++){
            int max = next+m;
            for(int j=next;j<max;j++){
                if(nums[j%n]==-1){
                    next++;
                    max++;
                }
                if(j==max-1){
                    nums[j%n] = -1;
                }
            }
            next+=m;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                return i;
            }
        }
        return 0;

    }
    public static void main(String[] args){
        System.out.println(lastRemaining1(10,17));
    }
}
