package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/9/23 10:23
 * @link https://leetcode-cn.com/problems/power-of-three/
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
