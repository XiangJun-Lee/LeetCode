package com.leetcode2022;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2021/10/14 10:37
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                left = mid;
            } else if (arr[mid] > arr[mid + 1] && arr[mid - 1] > arr[mid]) {
                right = mid;
            } else if (arr[mid] > arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                return mid;
            }
        }
        return left;
    }

    @Test
    public void test(){
        int[] arr = new int[]{0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
