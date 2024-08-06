package com.leetcode2022;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leelixiangjun
 * @date 2022/2/9 12:59
 */
public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            res += cnt.getOrDefault(num - k, 0) + cnt.getOrDefault(num + k, 0);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
