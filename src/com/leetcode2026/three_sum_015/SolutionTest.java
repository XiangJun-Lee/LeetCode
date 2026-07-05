package com.leetcode2026.three_sum_015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {
        Solution solution = new Solution();

        assertCase(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), solution, new int[]{-1, 0, 1, 2, -1, -4}, "official example 1");
        assertCase(listOf(), solution, new int[]{0, 1, 1}, "official example 2");
        assertCase(listOf(listOf(0, 0, 0)), solution, new int[]{0, 0, 0}, "official example 3");
        assertCase(listOf(listOf(0, 0, 0)), solution, new int[]{0, 0, 0, 0}, "repeated zeroes");
        assertCase(listOf(listOf(-2, 0, 2), listOf(-2, 1, 1)), solution, new int[]{-2, 0, 1, 1, 2}, "duplicate second and third values");
        assertCase(listOf(), solution, new int[]{1, 2, -2, -1}, "no valid triplet after sorting");
        assertCase(listOf(listOf(-4, 1, 3), listOf(-1, -1, 2), listOf(-1, 0, 1)), solution, new int[]{3, -1, -1, 0, 1, 2, -4}, "unsorted mixed values");
        assertCase(listOf(listOf(-5, 2, 3), listOf(-2, -1, 3)), solution, new int[]{-5, -2, -1, 2, 3, 4}, "pointer movement boundaries");

        System.out.println("All test cases passed.");
    }

    private static void assertCase(List<List<Integer>> expected, Solution solution, int[] input, String caseName) {
        AtomicReference<List<List<Integer>>> actual = new AtomicReference<>();
        Thread worker = new Thread(() -> actual.set(solution.threeSum(Arrays.copyOf(input, input.length))));
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

        assertEquals(normalize(expected), normalize(actual.get()), caseName);
    }

    private static Set<String> normalize(List<List<Integer>> triples) {
        Set<String> normalized = new HashSet<>();
        if (triples == null) {
            return normalized;
        }
        for (List<Integer> triple : triples) {
            if (triple == null || triple.size() != 3) {
                throw new AssertionError("Every result item must be a triplet, but got " + triple);
            }
            List<Integer> sorted = new ArrayList<>(triple);
            sorted.sort(Integer::compareTo);
            normalized.add(sorted.toString());
        }
        return normalized;
    }

    @SafeVarargs
    private static List<List<Integer>> listOf(List<Integer>... triples) {
        return new ArrayList<>(Arrays.asList(triples));
    }

    private static List<Integer> listOf(int a, int b, int c) {
        return Arrays.asList(a, b, c);
    }

    private static void assertEquals(Set<String> expected, Set<String> actual, String caseName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                    "Case " + caseName + " failed: expected " + expected + ", but got " + actual
            );
        }
    }
}
