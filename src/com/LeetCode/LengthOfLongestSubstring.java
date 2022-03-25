package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                int index = list.indexOf(c);
                for (int i = 0; i < index + 1; i++) {
                    list.remove(0);
                }
            }
            list.add(c);
            length = Math.max(length, list.size());
        }
        return length;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int n = s.length(), res = 0, start = 0;
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            int index = lastIndex.getOrDefault(si, -1);
            start = Math.max(start, index + 1);
            res = Math.max(res, i - start + 1);
            lastIndex.put(si, i);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> occ = new HashSet<>();
        int n = s.length(), left = 0, right = 0, ans = 0;
        for (; left < n && right < n; left++) {
            while (right < n && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
            occ.remove(s.charAt(left));
        }
        return ans;
    }
}
