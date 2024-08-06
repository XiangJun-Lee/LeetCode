package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/7 11:33
 */
public class SuperPow {
    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = ((res % MOD) * (pow(a, b[i]) % MOD)) % MOD;
            a = pow(a, 10);
        }
        return res;
    }

    private int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = ((res % MOD) * (x % MOD));
            }
            x = x % MOD;
            x = x * x;
            n /= 2;
        }
        return res;
    }

    @Test
    public void test() {
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(superPow(a, b));
    }
}
