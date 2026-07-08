package com.leetcode2026.maximum_subarray_053;

import java.util.concurrent.atomic.AtomicInteger;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {
        Solution solution = new Solution();

        assertCase(6, solution, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, "official mixed values");
        assertCase(1, solution, new int[]{1}, "single positive");
        assertCase(23, solution, new int[]{5, 4, -1, 7, 8}, "all positive with small dip");
        assertCase(-1, solution, new int[]{-2, -1, -3}, "all negative");
        assertCase(0, solution, new int[]{0}, "single zero");
        assertCase(4, solution, new int[]{0, -3, 4, -1, -2, 1}, "best starts after zero");
        assertCase(3, solution, new int[]{2, -1, 2}, "bridge small negative");
        assertCase(10, solution, new int[]{-5, 10, -20, 3}, "must reset before best");

        System.out.println("All test cases passed.");
    }

    private static void assertCase(int expected, Solution solution, int[] nums, String caseName) {
        AtomicInteger actual = new AtomicInteger();
        Thread worker = new Thread(() -> actual.set(solution.maxSubArray(nums)));
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

        assertEquals(expected, actual.get(), caseName);
    }

    private static void assertEquals(int expected, int actual, String caseName) {
        if (expected != actual) {
            throw new AssertionError(
                    "Case " + caseName + " failed: expected " + expected + ", but got " + actual
            );
        }
    }
}
