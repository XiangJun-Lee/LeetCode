package com.LeetCode.March;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leeixiangjun
 * @date 2022/3/17 10:10 上午
 */
public class March17 {
    public String longestWord(String[] words) {
        String ans = "";
        Arrays.sort(words, (o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : o2.compareTo(o1));
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                ans = word;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(words));
    }
}
