package com.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leelixiangjun
 * @date 2021/10/8 14:50
 * @link https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class FindRepeatedDnaSequences {
    public static final int L = 10;

    public static final Map<Character, Integer> bin = new HashMap<Character, Integer>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    /**
     * 哈希表 滑动窗口
     */
    public List<String> findRepeatedDnaSequencesMethod1(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        if (n < L) {
            return ans;
        }
        for (int i = 0; i <= n - L; i++) {
            // 截取第i位到第i+L位的子字符串
            String temp = s.substring(i, i + L);
            // 放入hashMap中，并计数
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            // 如果等于2个，则满足条件。之所以不>2，是为了避免重复计数。
            if (map.get(temp) == 2) {
                ans.add(temp);
            }
        }
        return ans;
    }

    /**
     * 位运算 哈希表 滑动窗口
     */
    public List<String> findRepeatedDnaSequencesMethod2(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n < L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - L; i++) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequencesMethod2(s));
    }
}
