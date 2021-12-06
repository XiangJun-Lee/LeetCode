package com.LeetCode;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/6 20:25
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }
            if (k == 0) {
                return s.substring(0, i);
            }
        }
        return s;
    }

    @Test
    public void test() {
        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }
}
