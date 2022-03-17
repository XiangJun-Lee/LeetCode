package com.LeetCode.Trie;

/**
 * @author leeixiangjun
 * @date 2022/3/17 10:44 上午
 */
public class Trie {
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
            if (trie.next[c - 'a'] == null) {
                return false;
            }
            trie = trie.next[c - 'a'];
        }
        return trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            if (trie.next[c - 'a'] == null) {
                return false;
            }
            trie = trie.next[c - 'a'];
        }
        return true;
    }
}
