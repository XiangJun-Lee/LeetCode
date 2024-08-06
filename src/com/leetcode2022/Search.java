package com.leetcode2022;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 */
public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int head = 0;
        int end = nums.length - 1;
        int mid;
        while (head <= end) {
            mid = head + (end - head) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            if (nums[head] <= nums[mid]) {
                if (target >= nums[head] && target < midNum) {
                    end = mid - 1;
                } else {
                    head = mid + 1;
                }
            } else {
                if (target > midNum && target <= nums[end]) {
                    head = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/binary-search/submissions/
     * @param nums
     * @param target
     * @return
     */
    public int searchTwo(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
