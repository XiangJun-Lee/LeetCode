package com.LeetCode;

import org.junit.Test;

import java.util.Random;

/**
 * @author leelixiangjun
 * @date 2021/12/22 13:25
 * @link https://leetcode-cn.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch {
    /**
     * 暴力破解法
     *
     * @param a
     * @param b
     * @return
     * @desc 考虑一种最不利的情况，从重复的第一个a的最后一个字符开始匹配，匹配完最后一个字符恰好是最后一个a的第一个字符。
     * 则最大字符数可能为(a.len() - 1) + b.len() + (a.len() - 1) = 2 * a.len() + b.len() - 2。这里要求小于（没有等于）2 * a.len() + b.len()应该是比最大可能字符数大1，不过无所谓。
     */
    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length(), max = 2 * an + bn, index;
        while ((index = a.indexOf(b)) < 0 && a.length() < max) {
            a += a;
        }
        return index < 0 ? -1 : (int) Math.ceil((double) (index + bn) / an);
    }

    @Test
    public void test() {
        String a = "abcd", b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }

    /**
     * Rabin-Karp 算法
     *
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatchOfficial(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        //生成两个mod值
        int kMod1 = random.nextInt(k1) + k1;
        int kMod2 = random.nextInt(k2) + k2;

        long hashNeedle = 0;
        // 计算子串的hash值
        for (int i = 0; i < m; i++) {
            hashNeedle = (hashNeedle * kMod2 + needle.charAt(i)) % kMod1;
        }

        long hashHaystack = 0, extra = 1;
        for (int i = 0; i < m - 1; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            extra = (extra * kMod2) % kMod1;
        }
        for (int i = m - 1; i < n - 1 + m; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            if (hashHaystack == hashNeedle) {
                return i - m + 1;
            }
            hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
            hashHaystack = (hashHaystack + kMod1) % kMod1;
        }
        return -1;
    }
}
