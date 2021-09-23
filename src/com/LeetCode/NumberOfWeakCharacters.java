package com.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leelixiangjun
 * @date 2021/9/23 10:49
 * @link https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 */
public class NumberOfWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        // 对数组进行排序，按攻击力由大到小排序；攻击力相同，按防御力由小到大排序。
        Arrays.sort(properties, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        // 定义弱角色总数，数组长度，最大防御力
        int res = 0, maxDefense = -1;
        for (int[] property : properties) {
            // 如果当前角色的防御力小于前面角色的最大防御力，则该角色为弱角色
            if (maxDefense > property[1]) {
                res++;
            }
            // 然后获取第i+1个角色之前的最大防御值
            maxDefense = Math.max(maxDefense, property[1]);
        }
        return res;
    }
}
