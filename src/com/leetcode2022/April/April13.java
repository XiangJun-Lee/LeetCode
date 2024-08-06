package com.leetcode2022.April;

import java.util.*;

/**
 * @author leelixiangjun
 * @date 2022/4/13 10:13
 */
public class April13 {
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> index;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            index = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (index.containsKey(val)) {
                return false;
            }
            index.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!index.containsKey(val)) {
                return false;
            }
            int vIndex = index.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(vIndex, last);
            index.put(last, vIndex);
            nums.remove(nums.size() - 1);
            index.remove(val);
            return true;
        }

        public int getRandom() {
            int r = random.nextInt(nums.size());
            return nums.get(r);
        }
    }
}
