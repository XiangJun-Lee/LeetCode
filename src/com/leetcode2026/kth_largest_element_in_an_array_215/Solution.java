package com.leetcode2026.kth_largest_element_in_an_array_215;

import java.util.Random;

public class Solution {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (left <= right) {
            int pivotIndex = random.nextInt(right - left + 1) + left;
            int finalIndex = partition(nums, left, right, pivotIndex);
            if (finalIndex == target) {
                return nums[finalIndex];
            }
            if (finalIndex > target) {
                right = finalIndex - 1;
            }
            if (finalIndex < target) {
                left = finalIndex + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int temp = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, temp);
                temp++;
            }
        }
        swap(nums, temp, right);
        return temp;
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
