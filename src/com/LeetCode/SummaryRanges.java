package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2021/10/9 20:37
 * @link https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 */
public class SummaryRanges {

    private boolean[] nums = new boolean[10001];

    public SummaryRanges() {
    }

    public void addNum(int val) {
        nums[val] = true;
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        int start = -1, end = -1;
        for (int i = 0; i < 10001; i++) {
            if (nums[i]) {
                start = start == -1 ? i : start;
                end = i;
            } else {
                if (start != -1) {
                    list.add(new int[]{start, end});
                    start = -1;
                    end = -1;
                }
            }
        }
        if (start != -1) {
            list.add(new int[]{start, end});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
