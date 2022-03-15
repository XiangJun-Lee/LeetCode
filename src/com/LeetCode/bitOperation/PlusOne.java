package com.LeetCode.bitOperation;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/15 2:07 下午
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int add = 1, len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (add == 0) {
                return digits;
            }
            digits[i] = (digits[i] + 1) % 10;
            add = (digits[i] + 1) / 10;
        }
        if (add == 1) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }

    @Test
    public void test(){
        int[] digits = {9};
        System.out.println(plusOne(digits));
    }
}
