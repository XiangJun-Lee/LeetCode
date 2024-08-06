package com.leetcode2022.String;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/4 10:45
 * @num 415
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String ans = "0";
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            for (int j = num2.length() - 1; j > i; j--) {
                temp.append("0");
            }
            int x = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int y = j >= 0 ? num1.charAt(j) - '0' : 0;
                temp.append((x * y + carry) % 10);
                carry = (x * y + carry) / 10;
            }
            ans = addStrings(ans, temp.reverse().toString());
        }
        return ans;
    }

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
        System.out.println(multiply("123", "456"));
    }
}
