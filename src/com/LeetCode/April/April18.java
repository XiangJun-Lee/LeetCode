package com.LeetCode.April;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/4/18 12:20
 */
public class April18 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ans.add(number);
            if (number * 10 < n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number >= n) {
                    number /= 10;
                }
                number++;
            }
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(lexicalOrder(10));
    }
}
