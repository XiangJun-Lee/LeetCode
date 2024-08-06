package com.leetcode2022.March;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/15 1:51 下午
 */
public class March15 {
    int max = 0;
    int cnt = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            max |= nums[i];
        }
        dfs(nums, 0, 0);
        return cnt;
    }

    /**
     *
     * @param nums
     * @param index
     * @param cur
     */
    private void dfs(int[] nums, int index, int cur) {
        if (index == nums.length) {
            cnt += cur == max ? 1 : 0;
            return;
        }
        dfs(nums, index + 1, cur | nums[index]);
        dfs(nums, index + 1, cur);
    }

    @Test
    public void test() {
        int[] nums = {3,2,1,5};
        System.out.println(countMaxOrSubsets(nums));
    }
}
