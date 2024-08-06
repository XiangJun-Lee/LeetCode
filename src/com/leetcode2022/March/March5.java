package com.leetcode2022.March;

/**
 * @author leelixiangjun
 * @date 2022/3/29 20:06
 * @link  https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 */
public class March5 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
