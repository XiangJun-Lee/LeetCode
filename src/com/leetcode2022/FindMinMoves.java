package com.leetcode2022;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leelixiangjun
 * @date 2021/9/29 18:08
 */
public class FindMinMoves {
    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }

    @Test
    public void test(){
        int[] m = {1,1,6,11,1};
        System.out.println(findMinMoves(m));
    }
}
