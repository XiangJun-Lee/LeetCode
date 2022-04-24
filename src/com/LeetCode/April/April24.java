package com.LeetCode.April;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/4/24 20:55
 */
public class April24 {
    public int binaryGap(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        int count = 0, ans = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = Math.max(ans, count);
                count = 0;
            }
            count++;
            n /= 2;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(binaryGap(22));
    }
}
