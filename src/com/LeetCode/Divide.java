package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/10/13 11:05
 * @link
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            // 只要不是最小的那个整数，都是直接返回相反数就好啦
            if (dividend > Integer.MIN_VALUE) return -dividend;
            // 是最小的那个，那就返回最大的整数啦
            return Integer.MAX_VALUE;
        }
        // 将int入参转为long，便于后序计算
        long a = dividend;
        long b = divisor;
        // 计算结果的正负号
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        // 将入参转为正数
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        // 计算商
        long res = div(a, b);
        return (int) (sign * res);
    }

    private long div(long a, long b) {
        if (a < b) return 0;
        int count = 1;
        long tempDivisor = b;
        // 如果把除数翻倍之后，还小于等于被除数。那么，count翻倍，除数翻倍。
        while ((tempDivisor + tempDivisor) <= a) {
            count += count;
            tempDivisor += tempDivisor;
        }
        // 递归此过程
        return count + div(a - tempDivisor, b);
    }
}
