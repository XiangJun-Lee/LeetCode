package com.LeetCode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
    	if(s.length()<=1) {
    		return s;
    	}
    	char[] ss = s.toCharArray();
    	int head = 0;
    	int end = ss.length-1;
    	while(head != ss.length-2) {
    		if(ss[head]!=ss[end]) {
    			continue;
    		}
    		
    	}
    	return s;
    }
}
