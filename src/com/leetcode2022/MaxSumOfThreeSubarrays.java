package com.leetcode2022;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author leeixiangjun
 * @date 2021/12/8 10:52 下午
 */
public class MaxSumOfThreeSubarrays {

    public int[] maxSumOfOneSubarrays(int[] nums, int k) {
        int[] ans = new int[1];
        int sum1 = 0, maxSum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (i > k) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    ans[0] = i - (k - 1);
                }
                sum1 -= nums[i - (k - 1)];
            }
        }
        return ans;
    }

    public int[] maxSumOfTwoSubarrays(int[] nums, int k) {
        int[] ans = new int[2];
        int sum1 = 0, maxSum1 = 0, maxSum1Index = 0;
        int sum2 = 0, maxSum2 = 0;
        for (int i = k; i < nums.length; i++) {
            sum1 += nums[i - k];
            sum2 += nums[i];
            if (i > 2 * k) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Index = i - (k * 2 - 1);
                }
                if (sum2 + maxSum1 > maxSum2) {
                    maxSum2 = sum2 + maxSum1;
                    ans[0] = maxSum1Index;
                    ans[1] = i - (k - 1);
                }
                sum1 -= nums[i - (k * 2 - 1)];
                sum2 -= nums[i - (k - 1)];
            }
        }
        return ans;
    }


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Index1 = 0;
        int sum2 = 0, maxSum2 = 0, maxSum2Index1 = 0, maxSum2Index2 = 0;
        int sum3 = 0, maxSum3 = 0;
        for (int i = k * 2; i < nums.length; i++) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i > 3 * k) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Index1 = i - k * 3 + 1;
                }
                if (sum2 + maxSum1 > maxSum2) {
                    maxSum2 = sum2 + maxSum1;
                    maxSum2Index1 = maxSum1Index1;
                    maxSum2Index2 = i - k * 2 + 1;
                }
                if (sum3 + maxSum2 > maxSum3) {
                    maxSum3 = sum3 + maxSum2;
                    ans[0] = maxSum2Index1;
                    ans[1] = maxSum2Index2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        System.out.println(Arrays.toString(maxSumOfOneSubarrays(nums, 2)));
        System.out.println(Arrays.toString(maxSumOfTwoSubarrays(nums, 2)));
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, 2)));
    }
}
