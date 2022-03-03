package com.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leelixiangjun
 * @date 2022/3/3 15:27
 */
public class CheckSubarraySum {
    /**
     * 连续子数组求和，使用前缀和方式
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            if (sum == 0 && i >= 1) {
                return true;
            }
            if (map.containsKey(sum)) {
                Integer index = map.get(sum);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {23, 2, 4, 6, 6};

        System.out.println(checkSubarraySum(nums, 7));
    }
}
