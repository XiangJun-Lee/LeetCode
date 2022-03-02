package com.LeetCode.March;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Xiangjun_Lee
 * @date:2022/3/1 21:49
 */
public class March1 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len < numRows) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
