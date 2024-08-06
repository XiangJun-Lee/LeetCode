package com.leetcode2022.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leeixiangjun
 * @date 2022/3/3 11:22 下午
 * @number 47
 */
public class PermuteUnique {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        // 先对数组进行排序，保证重复的数字挨着
        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, used);
        return ans;
    }

    private void dfs(List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
