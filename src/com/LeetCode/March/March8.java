package com.LeetCode.March;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leeixiangjun
 * @date 2022/3/8 10:35 上午
 */
public class March8 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // n为字符串的长度
        // sumPlates用于记录每个位置上盘子的前缀和
        // rightIndex用于记录在index右边，且最靠近index的蜡烛的位置
        // leftIndex用于记录在index左边，且最靠近index的蜡烛的位置
        int n = s.length(), sumPlates = 0, leftIndex = 0, rightIndex = s.length() - 1;
        // 结果集
        int[] ans = new int[queries.length];
        // dp用于记录每个位置盘子数量的前缀和
        // leftCandle用于记录每个位置左侧最靠近他的蜡烛的位置
        // rightCandle用于记录每个位置右侧最靠近他的蜡烛的位置
        int[] dp = new int[n], rightCandle = new int[n], leftCandle = new int[n];
        for (int i = 0; i < n; i++) {
            // 累加记录盘子的前缀和
            if (s.charAt(i) == '*') {
                sumPlates++;
            }
            // 如果位置i是蜡烛，更新左侧最近蜡烛的位置
            if (s.charAt(i) == '|') {
                leftIndex = i;
            }
            // 如果位置n-1-i是蜡烛，更新右侧最近蜡烛的位置
            if (s.charAt(n - 1 - i) == '|') {
                rightIndex = n - 1 - i;
            }
            // 位置i左边，且最靠近位置i的蜡烛的位置
            leftCandle[i] = leftIndex;
            // 位置右侧，且最靠近该位置的蜡烛的位置
            rightCandle[n - 1 - i] = rightIndex;
            // 位置i盘子的前缀和。
            dp[i] = sumPlates;
        }
        for (int i = 0; i < queries.length; i++) {
             // 找到区间左侧第一个蜡烛的位置，从左向右找，所以，要最靠近左节点右侧的蜡烛位置
            int left = rightCandle[queries[i][0]];
             // 找到区间右侧第一个蜡烛的位置，从右向左找，所以，要最靠近右节点左侧的蜡烛位置
            int right = leftCandle[queries[i][1]];
            // 如果right<=left，说明区间中间没有蜡烛，满足条件的盘子数为0
            ans[i] = right <= left ? 0 : dp[right] - dp[left];
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
    }
}
