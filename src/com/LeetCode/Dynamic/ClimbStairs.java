package com.LeetCode.Dynamic;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/3 14:40
 */
public class ClimbStairs {
    // 递归
    public int climbStairs1(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 斐波那切数列 f(n) = f(n-1)+f(n-2)
    public int climbStairs(int n) {
        int p , q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    @Test
    public void test() {
        System.out.println(climbStairs(45));
    }
}
