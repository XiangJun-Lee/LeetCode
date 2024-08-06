package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/10 14:54
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = countLetters(licensePlate);
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            int[] curCnt = countLetters(words[i]);
            boolean isOk = isCompletingWord(cnt, curCnt);
            if (isOk && (index < 0 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        return words[index];
    }

    private boolean isCompletingWord(int[] cnt, int[] curCnt) {
        boolean isOk = true;
        for (int j = 0; j < 26; j++) {
            if (curCnt[j] < cnt[j]) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    private int[] countLetters(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }
        return cnt;
    }

    @Test
    public void test(){
        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        System.out.println(shortestCompletingWord(licensePlate,words));
    }
}
