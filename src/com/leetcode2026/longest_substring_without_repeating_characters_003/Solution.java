package com.leetcode2026.longest_substring_without_repeating_characters_003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right=0;
        Set<Character> selectedCharacter = new HashSet<>();
        int maxLength = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            if (!selectedCharacter.contains(c)){
                selectedCharacter.add(c);
                right++;
                int length = right - left ;
                maxLength = Math.max(length, maxLength);
                continue;
            }
            selectedCharacter.remove(s.charAt(left));
            left++;
        }
        return maxLength;
    }
}
