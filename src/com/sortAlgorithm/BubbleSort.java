package com.sortAlgorithm;

/**
 * 冒泡排序
 * @author leelixiangjun
 * @date 2022/3/30 22:47
 */
public class BubbleSort {
    /**
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3. 针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; i < n - i - i; i++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
