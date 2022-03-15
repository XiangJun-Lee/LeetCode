package com.LeetCode.March;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leeixiangjun
 * @date 2022/3/14 10:02 上午
 */
public class March14 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < minIndexSum) {
                    ans.clear();
                    ans.add(list2[i]);
                    minIndexSum = i + j;
                } else if (i + j == minIndexSum) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
