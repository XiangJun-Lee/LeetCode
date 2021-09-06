package com.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length==0) return "";
        if(length==1) return strs[0];

        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[length-1].toCharArray();
        int max = Math.min(first.length,last.length);
        for(int i=0;i<max;i++){
            if(first[i]!=last[i])break;
            res.append(first[i]);
        }
        return res.toString();
    }

    @Test
    public void test(){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
