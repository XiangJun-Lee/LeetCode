package com.LeetCode;

import java.util.Arrays;

/**
 * @author leeixiangjun
 * @date 2021/12/20 11:11 下午
 * @link https://leetcode-cn.com/problems/heaters/
 */
public class FindRadius {

    /**
     * 解题思路：对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离
     *
     * @param houses
     * @param heaters
     * @return
     */

    /**
     * 二分法
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int d;
            if (house <= heaters[0]) {
                d = heaters[0] - house;
            }else if (heaters[heaters.length - 1] <= house) {
                d = house - heaters[heaters.length - 1];
            }else {
                int left = 0, right = heaters.length - 1;
                while (left < right) {
                    int mid = (right + left) >> 1;
                    if (heaters[mid] < house) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                d = Math.min(heaters[left] - house, house - heaters[left - 1]);
            }
            ans = Math.max(ans, d);
        }
        return ans;
    }

    /**
     * 双指针法
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius2(int[] houses, int[] heaters) {
        int j = 0;
        int ans = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int d;
            while (j < heaters.length && heaters[j] < houses[i]) {
                j++;
            }
            if (j == 0) {
                d = heaters[j] - houses[i];
            } else if (j == heaters.length - 1) {
                d = houses[i] - heaters[j];
            } else {
                d = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]);
            }
            ans = Math.max(ans, d);
        }
        return ans;
    }
}
