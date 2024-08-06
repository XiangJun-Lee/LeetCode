package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/7 14:23
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] letter = new char[26];
        for (char l : magazine.toCharArray()) {
            letter[l - 'a']++;
        }
        for (char l : ransomNote.toCharArray()) {
            if (letter[l - 'a'] == 0) {
                return false;
            }
            letter[l - 'a']--;
        }
        return true;
    }

    @Test
    public void test(){
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
