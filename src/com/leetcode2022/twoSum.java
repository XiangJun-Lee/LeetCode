package com.leetcode2022;

import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++) {
    		int another = target - nums[i];
    		if(numMap.containsKey(another)) {
    			return (new int[] {numMap.get(another),i});
    		}
    		if(target - nums[i]>0) {
        		numMap.put(nums[i], i);
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args) {
    	
    	int[] nums = {3,2,5};
    	int[] result = new twoSum().twoSum(nums, 5);
    	System.out.println(result[0]+","+result[1]);
    	
   
    }
}
