package com.LeetCode.Dynamic;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/3 11:08
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return s;
        }
        int len = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int maxEnd = 0, maxLen = 0;
        int[][] arr = new int[len + 1][len + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = len - j;
                    if (beforeRev + arr[i][j] == i) {
                        maxEnd = i;
                        maxLen = arr[i][j];
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen, maxEnd);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
