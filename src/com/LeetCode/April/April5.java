package com.LeetCode.April;

/**
 * @author leelixiangjun
 * @date 2022/4/5 0:22
 */
public class April5 {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += isPrime(bitCount(i));
        }
        return ans;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
            count += (num % 2);
            num = num >> 1;
        }
        return count;
    }

    private int isPrime(int num) {
        if (num < 2) {
            return 0;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    class Solution {
        public int countPrimeSetBits(int left, int right) {
            int ans = 0;
            for (int x = left; x <= right; ++x) {
                if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                    ++ans;
                }
            }
            return ans;
        }
    }
}
