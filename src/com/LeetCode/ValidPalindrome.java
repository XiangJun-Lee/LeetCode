package com.LeetCode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if(len<=1) return true;
        int head=0;int end = len-1;
        while (head<=end){
            if(s.charAt(head)!=s.charAt(end)){
                if(check(s.substring(head,end))==false){
                    return check(s.substring(head+1,end+1));
                }
                return true;
            }
            head++;
            end--;
        }
        return true;
    }

    private boolean check(String substring) {
        int len = substring.length();
        if(len<=1) return true;
        int head=0;int end = len-1;
        while (head<=end){
            if(substring.charAt(head)!=substring.charAt (end)){
                return false;
            }
            head++;
            end--;
        }
        return true;
    }

    @Test
    public void test(){
        String s = "abc";
        System.out.println(validPalindrome(s));
    }
}
