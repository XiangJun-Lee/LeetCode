package com.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leeixiangjun
 * @date 2021/12/15 10:55 下午
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // 记录比自己富有的人
        List<Integer>[] rich = new List[n];
        for (int i = 0; i < rich.length; i++) {
            rich[i] = new ArrayList<>(n);
        }
        for (int i = 0; i < richer.length; i++) {
            rich[richer[i][1]].add(richer[i][0]);
        }
        // 初始化返回值
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            dfs(i, ans, rich, quiet);
        }
        return ans;
    }

    private void dfs(int x, int[] ans, List<Integer>[] rich, int[] quiet) {
        if (ans[x] != -1) {
            return;
        }
        // 将安静值最小的先设置为自己
        ans[x] = x;
        for (Integer y : rich[x]) {
            // 递归比自己富有的人
            dfs(y, ans, rich, quiet);
            // 比较
            if (quiet[ans[x]] > quiet[ans[y]]) {
                ans[x] = ans[y];
            }
        }
    }
}
