package com.leetcode2022.April;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author leelixiangjun
 * @date 2022/4/14 13:24
 */
public class April14 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(account -> Arrays.stream(account).sum()).max(Comparator.naturalOrder()).get();
    }
}
