package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/7/24 11:16
 */
public class MaximumTime {
    public String maximumTime(String time) {
        char[] nums = time.toCharArray();
        if (nums[0] == '?') {
            nums[0] = nums[1] != '?' && nums[1] >= '4' && nums[1] <= '9' ? '1' : '2';
        }
        if (nums[1] == '?') {
            nums[1] = nums[0] == '1' ? '9' : '3';
        }
        if (nums[3] == '?') {
            nums[3] = '5';
        }
        if (nums[4] == '?') {
            nums[4] = '9';
        }
        return new String(nums);
    }


}
