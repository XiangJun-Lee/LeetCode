package com.leetcode2022.April;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/4/11 20:08
 */
public class April11 {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int count = countNumbersWithUniqueDigits(i, new int[10], true);
            ans += count;
        }
        return ans;
    }

    private int countNumbersWithUniqueDigits(int n, int[] nums, boolean isStart) {
        if (n == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = isStart ? 1 : 0; i < 10; i++) {
            if (nums[i] != 1) {
                nums[i] = 1;
                ans += countNumbersWithUniqueDigits(n - 1, nums, false);
                nums[i] = 0;
            }
        }
        return ans;
    }

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }
            int res = 10, cur = 9;
            for (int i = 0; i < n - 1; i++) {
                cur *= 9 - i;
                res += cur;
            }
            return res;
        }
    }

    @Test
    public void test() {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
