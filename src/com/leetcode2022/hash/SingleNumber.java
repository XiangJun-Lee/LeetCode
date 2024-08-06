package com.leetcode2022.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeixiangjun
 * @date 2022/3/18 11:30 上午
 */
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            ans[i++] = num;
        }

        return ans;
    }
}
