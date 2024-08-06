package com.leetcode2022;

import org.junit.Test;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        if(p.equals("*")||s.equals(p)) return true;
        if (s.isEmpty()&&!s.equals("*")) return false;
        int sLength = s.length();
        int pLength = p.length();
        char[] sLetters = s.toCharArray();
        char[] pLetters = p.toCharArray();
        boolean[][] dp = new boolean[pLength+1][sLength+1];
        dp[0][0] = true;
        for(int i=1;i<=pLength;i++){
            for(int j=1;j<=sLength;j++){
                if (sLetters[j-1]==pLetters[i-1]||pLetters[i-1]=='?') dp[i][j] = dp[i-1][j-1];
                else if (pLetters[i-1]=='*') dp[i][j]=true;
            }

        }
        return dp[pLength][sLength];
    }

    @Test
    public void  test(){
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s,p));
    }
}
