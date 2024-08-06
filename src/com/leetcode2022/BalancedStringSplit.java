package com.leetcode2022;

/**
 * @author leelixiangjun
 * @date 2021/9/7 16:53
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int result = 0, delta = 0;
        char[] words = s.toCharArray();
        for (char c : words) {
            delta = delta + (c == 'L' ? 1 : -1);
            result = result + (delta == 0 ? 1 : 0);
        }
        return result;
    }
}
