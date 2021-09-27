package com.LeetCode;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/9/26 11:43
 */
public class GetSum {
    public int getSum(int a, int b) {
        do {
            System.out.println("【输入】a= " + a + "(" + Integer.toBinaryString(a) + ")" + " b= " + b + "("
                    + Integer.toBinaryString(b) + ")");
            int carry = (a & b) << 1;
            System.out.println("【执行】int carry = (a & b) << 1");
            System.out.println("【结果】carry = " + carry + "(" + Integer.toBinaryString(carry) + ")");
            a = a ^ b;
            System.out.println("【执行】a = a ^ b;");
            System.out.println("【结果】a = " + a + "(" + Integer.toBinaryString(a) + ")");
            b = carry;
            System.out.println("【执行】b = carry;");
            System.out.println("【结果】b = " + b + "(" + Integer.toBinaryString(b) + ")");
            if (b != 0) {
                System.out.println("【执行】while (b != 0) 从头开始");
            }
        } while (b != 0);
        return a;
    }

    @Test
    public void test() {
        System.out.println(getSum(7, 1));
    }
}
