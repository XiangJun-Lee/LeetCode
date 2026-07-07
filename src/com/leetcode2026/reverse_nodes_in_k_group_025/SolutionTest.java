package com.leetcode2026.reverse_nodes_in_k_group_025;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;
    private static final int MAX_OUTPUT_NODES = 6000;

    public static void main(String[] args) {
        assertCase("official example k=2", new int[]{1, 2, 3, 4, 5}, 2, new int[]{2, 1, 4, 3, 5});
        assertCase("official example k=3", new int[]{1, 2, 3, 4, 5}, 3, new int[]{3, 2, 1, 4, 5});
        assertCase("single node", new int[]{1}, 1, new int[]{1});
        assertCase("k equals length", new int[]{1, 2, 3}, 3, new int[]{3, 2, 1});
        assertCase("repeated values", new int[]{2, 2, 3, 3, 4, 4}, 2, new int[]{2, 2, 3, 3, 4, 4});
        assertCase("tail shorter than k", new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{3, 2, 1, 6, 5, 4, 7});
        assertCase("k is one", new int[]{9, 8, 7}, 1, new int[]{9, 8, 7});
        assertCase("two full groups", new int[]{1, 2, 3, 4}, 2, new int[]{2, 1, 4, 3});

        System.out.println("All test cases passed.");
    }

    private static void assertCase(String caseName, int[] input, int k, int[] expected) {
        Solution solution = new Solution();
        ListNode head = build(input);
        AtomicReference<ListNode> actual = new AtomicReference<>();
        Throwable[] thrown = new Throwable[1];

        Thread worker = new Thread(() -> {
            try {
                actual.set(solution.reverseKGroup(head, k));
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

        assertArrayEquals(expected, toArray(actual.get(), caseName), caseName);
    }

    private static ListNode build(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static int[] toArray(ListNode head, String caseName) {
        int[] values = new int[128];
        int size = 0;
        ListNode current = head;
        while (current != null) {
            if (size >= MAX_OUTPUT_NODES) {
                throw new AssertionError("Case " + caseName + " appears to contain a cycle");
            }
            if (size == values.length) {
                values = Arrays.copyOf(values, values.length * 2);
            }
            values[size++] = current.val;
            current = current.next;
        }
        return Arrays.copyOf(values, size);
    }

    private static void assertArrayEquals(int[] expected, int[] actual, String caseName) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(
                    "Case " + caseName + " failed: expected "
                            + Arrays.toString(expected) + ", but got " + Arrays.toString(actual)
            );
        }
    }
}
