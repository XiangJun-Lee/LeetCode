package com.LeetCode.March;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/3/31 10:25
 */
public class March31 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumber(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isDividingNumber(int num) {
        int temp = num;
        while (temp != 0) {
            int divid = temp % 10;
            if (divid == 0 || num % divid != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
