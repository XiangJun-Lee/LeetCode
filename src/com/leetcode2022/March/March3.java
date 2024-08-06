package com.leetcode2022.March;

/**
 * @author leelixiangjun
 * @date 2022/3/3 10:33
 */
public class March3 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int res = 0;
        while (num >= 10) {
            res += num % 10;
            num /= 10;
        }
        res += num;
        return addDigits(res);
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
