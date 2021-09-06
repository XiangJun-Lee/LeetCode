package com.LeetCode;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        int maxLength=0;
        HashSet<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }
        for(int num:nums){
            if(set.contains(num-1)) continue;
            int localMax = 1;
            while (set.contains(++num)){
                localMax++;
            }
            maxLength = Math.max(localMax,maxLength);
        }
        return maxLength;
    }

    @Test
    public void test(){
        int[] nums ={100, 4, 200, 1, 3, 2,5,7,6,10,101,102,103,104,106,105,107};
        System.out.println(longestConsecutive(nums));
    }
}
