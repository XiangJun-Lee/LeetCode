package com.leetcode2022;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leelixiangjun
 * @date 2021/11/1 10:45
 * @link https://leetcode-cn.com/problems/distribute-candies/
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candy = new HashSet<>();
        for (int c : candyType) {
            candy.add(c);
        }
        return Math.min(candy.size(), (candyType.length / 2));
    }
}
