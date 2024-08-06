package com.leetcode2022.March;

/**
 * @author leeixiangjun
 * @date 2022/3/22 10:34 上午
 */
public class March22 {
    public boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int cA = 0, cB = 0, n = chars.length;
        for (int i = 1; i < n - 1; i++) {
            if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') cA++;
            else if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') cB++;
        }
        return cA > cB;
    }
}
