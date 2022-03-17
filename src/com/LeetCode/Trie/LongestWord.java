package com.LeetCode.Trie;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/17 11:03 上午
 */
public class LongestWord {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String ans = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    class Trie {
        boolean isEnd;
        Trie[] next;

        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie trie = this;
            for (char c : word.toCharArray()) {
                if (trie.next[c - 'a'] == null) {
                    trie.next[c - 'a'] = new Trie();
                }
                trie = trie.next[c - 'a'];
            }
            trie.isEnd = true;
        }

        public boolean search(String word) {
            Trie trie = this;
            for (char c : word.toCharArray()) {
                if (trie.next[c - 'a'] == null || !trie.next[c - 'a'].isEnd) {
                    return false;
                }
                trie = trie.next[c - 'a'];
            }
            return trie.isEnd;
        }
    }


    @Test
    public void test() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(words));
    }
}
