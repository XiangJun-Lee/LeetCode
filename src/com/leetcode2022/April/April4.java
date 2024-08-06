package com.leetcode2022.April;

/**
 * @author leelixiangjun
 * @date 2022/4/4 15:55
 */
public class April4 {
    class NumArray {
        int[] sum;
        int[] nums;
        int size;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            size = (int) Math.sqrt(n);
            sum = new int[(n + size - 1) / size];
            for (int i = 0; i < n; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int block1 = left / size, index1 = left % size, block2 = right / size, index2 = right % size;
            if (block1 == block2) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                return sum;
            }
            int sum1 = 0;
            for (int i = index1; i < size; i++) {
                sum1 += nums[block1 * size + i];
            }
            int sum2 = 0;
            for (int i = 0; i <= index2; i++) {
                sum2 += nums[block2 * size + i];
            }
            int sum3 = 0;
            for (int i = block1 + 1; i < block2; i++) {
                sum3 += sum[i];
            }
            return sum1 + sum2 + sum3;
        }
    }
}
