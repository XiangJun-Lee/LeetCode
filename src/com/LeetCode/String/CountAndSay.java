package com.LeetCode.String;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/14 10:28 上午
 */
public class CountAndSay {
    public String countAndSay(int n) {
        return countAndSay("1", 1, n);
    }

    private String countAndSay(String res, int cur, int n) {
        if (cur == n) {
            return res;
        }
        StringBuilder ans = new StringBuilder();
        int num = 1;
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                num++;
            } else {
                ans.append(num).append(chars[i]);
                num = 1;
            }
        }
        ans.append(num).append(chars[chars.length - 1]);
        return countAndSay(ans.toString(), cur + 1, n);
    }

    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }
}
