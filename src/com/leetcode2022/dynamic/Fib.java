package com.leetcode2022.dynamic;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/2 20:22
 */
public class Fib {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    @Test
    public void test() {
        System.out.println(fib(4));
    }
}
