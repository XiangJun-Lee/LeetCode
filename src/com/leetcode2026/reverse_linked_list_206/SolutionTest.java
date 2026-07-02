package com.leetcode2026.reverse_linked_list_206;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class SolutionTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {
        assertCase("official example", new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        assertCase("two nodes", new int[]{1, 2}, new int[]{2, 1});
        assertCase("empty list", new int[]{}, new int[]{});
        assertCase("single node", new int[]{7}, new int[]{7});
        assertCase("duplicate values", new int[]{1, 1, 2, 3}, new int[]{3, 2, 1, 1});
        assertCase("negative values", new int[]{-1, 0, 2}, new int[]{2, 0, -1});

        System.out.println("All test cases passed.");
    }

    private static void assertCase(String caseName, int[] input, int[] expected) {
        Solution solution = new Solution();
        ListNode head = build(input);
        AtomicReference<ListNode> actual = new AtomicReference<>();
        Throwable[] thrown = new Throwable[1];

        Thread worker = new Thread(() -> {
            try {
                actual.set(solution.reverseList(head));
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

        assertArrayEquals(expected, toArray(actual.get()), caseName);
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

    private static int[] toArray(ListNode head) {
        int[] values = new int[128];
        int size = 0;
        ListNode current = head;
        while (current != null) {
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
