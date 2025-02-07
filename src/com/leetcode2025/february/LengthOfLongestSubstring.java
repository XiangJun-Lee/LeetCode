package com.leetcode2025.february;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leelixiangjun
 * @date 2025/2/7 08:26
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        int maxLength = 0;
        Set<Character> characters = new HashSet<>();
        while (right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right++;
                length++;
                maxLength = Math.max(maxLength, length);
                continue;
            }
            characters.remove(s.charAt(left));
            left++;
            length--;
        }
        return maxLength;
    }
}
