package com.leetcode2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leelixiangjun
 * @date 2021/9/23 14:45
 * @link https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {
    // 排序法
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    //
    public boolean isAnagramOffical(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer num = map.getOrDefault(c, 0);
            if (num == 0) {
                return false;
            }
            map.put(c, num - 1);
        }
        return true;
    }

}
