package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/12/23 20:23
 */
public class RabinKarp {
    public void RabinKarpAlgorithm(String t, String p) {
        int n = t.length(), m = p.length();
        if (n < m) {
            return;
        }
    }


    /**
     * 暴力破解
     * @param source
     * @param target
     * @return
     */
    public int BruteForceAlgorithm(String source, String target) {
        if (target.length() == 0) {
            return 0;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            if (equals(sourceArr, targetArr, i, i + targetArr.length - 1)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(char[] source, char[] target, int start, int end) {
        if (end >= source.length) {
            return false;
        }
        for (int i = 0; i <= end - start; i++) {
            if (source[i + start] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
