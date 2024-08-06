package com.leetcode2022.April;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leelixiangjun
 * @date 2022/4/12 17:39
 */
public class April12 {

    public int[] numberOfLines(int[] widths, String s) {
        int curLength = 0;
        int countLine = 1;
        for (char c : s.toCharArray()) {
            int length = widths[c - 'a'];
            if (curLength + length > 100) {
                countLine++;
                curLength = 0;
            }
            curLength += length;
        }
        return new int[]{countLine, curLength};
    }

    @Test
    public void test(){
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths, S)));
    }
}
