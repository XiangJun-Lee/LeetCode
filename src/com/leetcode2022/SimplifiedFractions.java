package com.leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/2/11 10:24
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    // 辗转相除求最大公约数
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
