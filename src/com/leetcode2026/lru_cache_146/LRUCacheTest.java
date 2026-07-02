package com.leetcode2026.lru_cache_146;

import java.util.concurrent.atomic.AtomicInteger;

public class LRUCacheTest {
    private static final long CASE_TIMEOUT_MILLIS = 1000L;

    public static void main(String[] args) {
        assertCase("official example", LRUCacheTest::officialExample);
        assertCase("update existing key refreshes recency", LRUCacheTest::updateExistingKeyRefreshesRecency);
        assertCase("get refreshes recency", LRUCacheTest::getRefreshesRecency);
        assertCase("capacity one evicts every old key", LRUCacheTest::capacityOneEvictsEveryOldKey);
        assertCase("missing key returns minus one", LRUCacheTest::missingKeyReturnsMinusOne);

        System.out.println("All test cases passed.");
    }

    private static void officialExample() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1), "official get 1");
        cache.put(3, 3);
        assertEquals(-1, cache.get(2), "official get 2 after eviction");
        cache.put(4, 4);
        assertEquals(-1, cache.get(1), "official get 1 after eviction");
        assertEquals(3, cache.get(3), "official get 3");
        assertEquals(4, cache.get(4), "official get 4");
    }

    private static void updateExistingKeyRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);
        cache.put(3, 3);
        assertEquals(10, cache.get(1), "updated key keeps new value");
        assertEquals(-1, cache.get(2), "least recent old key is evicted");
    }

    private static void getRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1), "get 1 before eviction");
        cache.put(3, 3);
        assertEquals(-1, cache.get(2), "key 2 should be least recent");
        assertEquals(1, cache.get(1), "key 1 should remain");
        assertEquals(3, cache.get(3), "key 3 should remain");
    }

    private static void capacityOneEvictsEveryOldKey() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        assertEquals(1, cache.get(1), "capacity one get first");
        cache.put(2, 2);
        assertEquals(-1, cache.get(1), "capacity one evicts first");
        assertEquals(2, cache.get(2), "capacity one keeps second");
    }

    private static void missingKeyReturnsMinusOne() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1, cache.get(99), "missing key in empty cache");
        cache.put(1, 1);
        assertEquals(-1, cache.get(2), "missing key in non-empty cache");
    }

    private static void assertCase(String caseName, Runnable runnable) {
        AtomicInteger completed = new AtomicInteger();
        Throwable[] thrown = new Throwable[1];
        Thread worker = new Thread(() -> {
            try {
                runnable.run();
                completed.set(1);
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
        if (completed.get() != 1) {
            throw new AssertionError("Case " + caseName + " did not complete");
        }
    }

    private static void assertEquals(int expected, int actual, String caseName) {
        if (expected != actual) {
            throw new AssertionError(
                    "Case " + caseName + " failed: expected " + expected + ", but got " + actual
            );
        }
    }
}
