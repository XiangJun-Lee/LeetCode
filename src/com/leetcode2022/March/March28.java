package com.leetcode2022.March;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/28 0:03
 */
public class March28 {
    public boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n != 0) {
            int cur = n % 2;
            if (cur == pre) {
                return false;
            }
            pre = cur;
            n /= 2;
        }
        return true;
    }

    public boolean hasAlternatingBitsOfficial(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
