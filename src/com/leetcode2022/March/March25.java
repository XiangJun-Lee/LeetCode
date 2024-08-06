package com.leetcode2022.March;

/**
 * @author leelixiangjun
 * @date 2022/3/25 10:28
 */
public class March25 {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 5 == 0) {
                num /= 5;
                count++;
            }
        }
        return count;
    }
}
