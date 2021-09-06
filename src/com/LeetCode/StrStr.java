package com.LeetCode;

public class StrStr {
    public static int strStr(String haystack, String needle) {
    	if(haystack.equals(needle)||needle.equals("")) {
    		return 0;
    	}
    	int result = haystack.indexOf(needle);
    	return result;
    	
//    	String[] temp = haystack.split(needle);
//    	if(temp.length==1&&temp[0].length()==haystack.length()) {
//    		return -1;
//    	}
//    	return temp[0].length();
    	
    }
    public static void main(String[] args) {
    	String haystack = "hello";
    	String needle = "ll";
    	System.out.println(strStr(haystack,needle));
    }

}
