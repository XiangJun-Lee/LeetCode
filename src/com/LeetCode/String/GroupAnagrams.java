package com.LeetCode.String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeixiangjun
 * @date 2022/3/14 11:16 上午
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String string = getLettersCount(str);
            List<String> temp = map.getOrDefault(string, new ArrayList());
            temp.add(str);
            map.put(string, temp);
        }
        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

    private String getLettersCount(String str) {
        int[] letters = new int[26];
        for (char c : str.toCharArray()) {
            letters[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                sb.append('a' - i).append(letters[i]);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }
}
