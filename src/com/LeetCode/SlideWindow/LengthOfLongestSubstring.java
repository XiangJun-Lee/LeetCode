package com.LeetCode.SlideWindow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/3/4 15:19
 * @num 3
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        List<Character> arr = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (arr.contains(c)) {
                int index = arr.indexOf(c);
                for (int i = 0; i <=index; i++) {
                    arr.remove(0);
                }
            }
            arr.add(c);
            ans = Math.max(ans, arr.size());
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
