package com.LeetCode.offer;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/10 8:52 下午
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (nums.length - 1) / 2, ans = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (mid < target) {
                left = mid + 1;
            } else if (mid > target) {
                right = mid - 1;
            } else {
                break;
            }
        }
        if (nums[mid] != target) {
            return 0;
        }
        for (int i = mid; i >= left; i--) {
            if (nums[i] == target) {
                ans++;
            }
        }
        for (int i = mid; i <= right; i++) {
            if (nums[i] == target) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums,8));
    }
}
