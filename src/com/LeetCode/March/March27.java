package com.LeetCode.March;

/**
 * @author leelixiangjun
 * @date 2022/3/27 11:45
 */
public class March27 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int nSum = mean * (n + m);
        for (int roll : rolls) {
            nSum -= roll;
        }
        if (nSum < n || nSum > 6 * n) {
            return new int[0];
        }
        int[] ans = new int[n];
        int merchant = nSum / n, remainder = nSum % n;
        for (int i = 0; i < n; i++) {
            ans[i] = merchant + (remainder > i ? 1 : 0);
        }
        return ans;
    }
}
