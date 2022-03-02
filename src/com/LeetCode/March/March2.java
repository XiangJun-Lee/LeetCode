package com.LeetCode.March;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/3/2 10:48
 */
public class March2 {
    public String nearestPalindromic(String n) {
        long selfNum = Long.parseLong(n), ans = -1;
        List<Long> candidates = getCandidates(n);
        for (Long candidate : candidates) {
            if (candidate != selfNum) {
                if (ans == -1 || Math.abs(candidate - selfNum) < Math.abs(ans - selfNum)
                        || (Math.abs(candidate - selfNum) == Math.abs(ans - selfNum) && candidate < ans)) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuilder suffix = new StringBuilder(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            String candidate = sb.toString();
            candidates.add(Long.parseLong(candidate));
        }
        return candidates;
    }

    @Test
    public void test() {
        System.out.println(nearestPalindromic("2"));
    }
}
