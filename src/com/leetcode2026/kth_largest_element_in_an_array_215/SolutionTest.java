package com.leetcode2026.kth_largest_element_in_an_array_215;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {
        assertCase("official example one", new int[]{3, 2, 1, 5, 6, 4}, 2, 5);
        assertCase("official example two", new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4);
        assertCase("single element", new int[]{1}, 1, 1);
        assertCase("duplicate values", new int[]{2, 1, 2, 1, 2}, 2, 2);
        assertCase("negative values", new int[]{-1, -3, -2, -4}, 2, -2);
        assertCase("largest value", new int[]{7, 10, 4, 3, 20, 15}, 1, 20);
        assertCase("smallest value", new int[]{7, 10, 4, 3, 20, 15}, 6, 3);

        System.out.println("All test cases passed.");
    }

    private static void assertCase(String caseName, int[] nums, int k, int expected) {
        Solution solution = new Solution();
        int[] input = Arrays.copyOf(nums, nums.length);
        AtomicInteger actual = new AtomicInteger();
        Throwable[] thrown = new Throwable[1];

        Thread worker = new Thread(() -> {
            try {
                actual.set(solution.findKthLargest(input, k));
            } catch (Throwable t) {
                thrown[0] = t;
            }
        });
        worker.setDaemon(true);
        worker.start();

        try {
            worker.join(CASE_TIMEOUT_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError("Case " + caseName + " was interrupted", e);
        }

        if (worker.isAlive()) {
            throw new AssertionError("Case " + caseName + " timed out after " + CASE_TIMEOUT_MILLIS + " ms");
        }
        if (thrown[0] != null) {
            throw new AssertionError("Case " + caseName + " failed", thrown[0]);
        }
        if (actual.get() != expected) {
            throw new AssertionError("Case " + caseName + " failed: expected " + expected + ", but got " + actual.get());
        }
    }
}
