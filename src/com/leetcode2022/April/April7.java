package com.leetcode2022.April;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/4/7 12:16 上午
 */
public class April7 {
    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            loop1:
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break loop1;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    class Solution {
        // 字符串匹配
        public boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (s + s).contains(goal);
        }
    }

    @Test
    public void test() {

    }
}
