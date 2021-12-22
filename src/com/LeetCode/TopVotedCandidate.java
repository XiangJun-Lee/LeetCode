package com.LeetCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeixiangjun
 * @date 2021/12/11 8:58 上午
 */
public class TopVotedCandidate {
    List<Integer> tops = new ArrayList<>();
    Map<Integer, Integer> voteCounts = new HashMap<>();
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int top = -1;
        voteCounts.put(-1, -1);
        for (int person : persons) {
            voteCounts.put(person, voteCounts.getOrDefault(person, 0) + 1);
            // 在平局的情况下，最近获得投票的候选人将会获胜。
            if (voteCounts.get(person) >= voteCounts.get(top)) {
                top = person;
            }
            tops.add(top);
        }
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return tops.get(l);
    }
}
