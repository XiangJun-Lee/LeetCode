package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/9/15 20:34
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]>nums[mid+1]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}
