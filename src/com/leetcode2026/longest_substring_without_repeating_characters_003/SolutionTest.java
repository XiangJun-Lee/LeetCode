package com.leetcode2026.longest_substring_without_repeating_characters_003;

import java.util.concurrent.atomic.AtomicInteger;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
        assertCase(3, solution, "abcabcbb", "abcabcbb");
        assertCase(1, solution, "bbbbb", "bbbbb");
        assertCase(3, solution, "pwwkew", "pwwkew");
        assertCase(0, solution, "", "empty string");
        assertCase(1, solution, " ", "single space");
        assertCase(3, solution, "dvdf", "dvdf");
        assertCase(2, solution, "abba", "abba");
        assertCase(5, solution, "tmmzuxt", "tmmzuxt");

        System.out.println("All test cases passed.");
    }

    private static void assertCase(int expected, Solution solution, String input, String caseName) {
        AtomicInteger actual = new AtomicInteger();
        Thread worker = new Thread(() -> actual.set(solution.lengthOfLongestSubstring(input)));
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
