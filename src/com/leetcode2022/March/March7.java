package com.leetcode2022.March;

/**
 * @author leelixiangjun
 * @date 2022/3/7 10:04
 */
public class March7 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder ans = new StringBuilder();
        while (num > 7) {
            ans.append(num % 7);
            num /= 7;
        }
        ans.append(num);
        return ans.reverse().toString();
    }
}
