package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/1 15:24
 */
public class MaxPower {
    public int maxPower(String s) {
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        char[] letters = s.toCharArray();
        char demoLetter = letters[0];
        int curLetterSize = 0;
        for (char letter : letters) {
            if (letter != demoLetter) {
                res = Math.max(res, curLetterSize);
                demoLetter = letter;
                curLetterSize =1;
                continue;
            }
            curLetterSize++;
        }
        return Math.max(res, curLetterSize);
    }

    public int maxPowerOfficial(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        String s= "";
        System.out.println(maxPowerOfficial(s));
    }
}
