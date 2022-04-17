package com.LeetCode.April;

import org.junit.Test;

import java.util.*;

/**
 * @author leelixiangjun
 * @date 2022/4/17 22:55
 */
public class April17 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String ans = "";
        int maxCount = -1;
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        paragraph += " ";
        StringBuilder sb = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                String word = sb.toString();
                sb = new StringBuilder();
                if (bannedWords.contains(word)||word.equals("")) {
                    continue;
                }
                int curCount = wordCount.getOrDefault(word, 0) + 1;
                if (curCount > maxCount) {
                    maxCount = curCount;
                    ans = word;
                }
                wordCount.put(word, curCount);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }
}
