package com.leetcode2022;

/**
 * @author leelixiangjun
 * @date 2021/9/27 16:02
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        int n = s.length();
        // dp[i-2]=a , dp[i-1]=b, dp[i]=c
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = b * checkOneDigit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * checkTwoDigit(s.charAt(i - 1), s.charAt(i - 2))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    private long checkTwoDigit(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c2 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c2 == '1') {
                return 9;
            } else if (c2 == '2') {
                return 6;
            } else {
                return 0;
            }
        }
        return (c2 != '0' && ((c2 - '0') * 10 + (c1 - '0') <= 26)) ? 1 : 0;
    }

    private long checkOneDigit(char c) {
        if (c == '0') {
            return 0;
        }
        return c == '*' ? 9 : 1;
    }
}
