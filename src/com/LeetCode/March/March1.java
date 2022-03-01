package com.LeetCode.March;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/3/1 20:17
 */
public class March1 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length(), start = 0, time = 0;
        List<char[]> sub = new ArrayList<>();
        while (start < len) {
            int end = start + numRows - (time % 2 == 0 ? 0 : 2);
            end = Math.min(end, len);
            String subString = s.substring(start, end);
            if (time % 2 == 1) {
                subString = new StringBuilder(subString).reverse().toString();
            }
            sub.add(subString.toCharArray());
            start = end;
            time++;
        }
        StringBuilder resp = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < sub.size(); j++) {
                if (j % 2 == 1 && (i == 0 || i == numRows - 1)) {
                    continue;
                }

                char[] chars = sub.get(j);
                if (i >= chars.length) {
                    continue;
                }
                resp.append(chars[i]);
            }
        }
        return resp.toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }
}
