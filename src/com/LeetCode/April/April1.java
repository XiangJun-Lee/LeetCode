package com.LeetCode.April;

import org.junit.Test;

import java.util.*;

/**
 * @author leelixiangjun
 * @date 2022/4/1 20:26
 */
public class April1 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        // 存储每个值的个数
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // 0只能和0配对，所以0的个数必须是偶数。(提前剪枝)
        if (count.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        // 获取所有的值，并按照绝对值从小到大排序，以确保x一定在2x前面
        List<Integer> vals = new ArrayList<>(count.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));
        // 只要保证每个x的个数都小于等于2x的个数，就可以。
        for (int num : vals) {
            // 如果x的个数大于2x的个数，一定不能配对，不满足条件
            if (count.getOrDefault(2 * num, 0) < count.get(num)) {
                return false;
            }
            // 将2x的个数改成count(2x)-count(x)
            count.put(2 * num, count.getOrDefault(2 * num, 0) - count.get(num));
        }
        return true;
    }

    public boolean canReorderDoubled1(int[] arr) {
        // TreeMap<Integer, Integer> count = new TreeMap<>(Comparator.comparingInt(Math::abs));
        TreeMap<Integer, Integer> count = new TreeMap<>((o1, o2) -> o1 < 0 && o2 < 0 ? o2 - o1 : o1 - o2);
        TreeMap<Integer, Integer> count1 = new TreeMap<>(Comparator.comparingInt(Math::abs));
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> vals = new ArrayList<>(count.keySet());
        for (int x : vals) {
            if (count.getOrDefault(2 * x, 0) < count.get(x)) {
                return false;
            }
            count.put(2 * x, count.getOrDefault(2 * x, 0) - count.get(x));
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = {-1, -2, 2};
        System.out.println(canReorderDoubled1(nums));
    }
}
