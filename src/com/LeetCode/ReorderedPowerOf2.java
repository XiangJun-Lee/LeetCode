package com.LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leelixiangjun
 * @date 2021/10/28 10:55
 */
public class ReorderedPowerOf2 {
    Set<String> powerOf2Digits = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    private void init() {
        for (int i = 1; i < 1e9; i <<= 1) {
            powerOf2Digits.add(countDigits(i));
        }
    }

    private String countDigits(int i) {
        char[] n = new char[10];
        while (i > 0) {
            ++n[i % 10];
            i /= 10;
        }
        return new String(n);
    }

    @Test
    public void test(){
        System.out.println(reorderedPowerOf2(10));
    }
}
