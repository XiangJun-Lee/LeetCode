package com.LeetCode;

import org.junit.Test;
import sun.nio.cs.ext.MacHebrew;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int length =s.length();
        if(length<=1) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[length];
        int res=0;
        dp[0]=0;
        for(int i=1;i<length;i++){
            if(chars[i]==')'){
                if (chars[i-1]=='('){
                    dp[i]=(i>=2? dp[i-2]:0)+2;
                } else if (i-dp[i-1]>0&&chars[i-1-dp[i-1]]=='('){
                    dp[i]=dp[i-1]+(i-dp[i-1]>2 ? dp[i-dp[i-1]-2]:0)+2;
                }
                res= Math.max(res,dp[i]);
            }
        }

        return res;
    }
    @Test
    public void test(){
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
