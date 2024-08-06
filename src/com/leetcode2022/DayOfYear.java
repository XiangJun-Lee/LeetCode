package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/12/21 11:19
 */
public class DayOfYear {


    public int dayOfYear(String date) {
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            monthDays[2]++;
        }
        for (int i = 0; i < month; i++) {
            day += monthDays[i];
        }
        return day;
    }

    @Test
    public void test() {
        String date = "";
        System.out.println(dayOfYear(date));
    }
}
