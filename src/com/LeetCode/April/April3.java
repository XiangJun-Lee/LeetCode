package com.LeetCode.April;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/4/3 12:11 上午
 */
public class April3 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[left % n];
    }

    @Test
    public void test() {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'j'));

    }
}
