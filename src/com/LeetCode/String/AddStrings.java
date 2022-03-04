package com.LeetCode.String;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/4 10:57
 * @num 43
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int y = j >= 0 ? (num2.charAt(j) - '0') : 0;
            ans.append((x + y + add) % 10);
            add = (x + y + add) / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addStrings("9", "99"));
    }
}
