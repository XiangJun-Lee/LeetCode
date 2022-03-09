package com.LeetCode.Dynamic;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/9 2:33 下午
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, ans = Integer.MIN_VALUE, vPlus = values[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, values[i] - i + vPlus);
            vPlus = Math.max(vPlus, values[i] + 1);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
