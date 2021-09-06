package com.LeetCode;

public class LockNum {
    private static volatile Integer num = 1;


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer n) {
        num = n;
    }
}
