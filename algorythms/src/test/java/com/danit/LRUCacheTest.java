package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    @Test
    public void verifyThatCacheCanSaveData() {
        LRUCacheNaive cache = new LRUCacheNaive(10);
        cache.put(12, 333);
        assertEquals(333, cache.get(12));
    }

    @Test
    public void verifyThatCacheCanReplaceData() {
        LRUCacheNaive cache = new LRUCacheNaive(2);
        cache.put(1, 1); // only one and first
        cache.put(2, 2); // become first. (1, 1) second
        assertEquals(1,cache.get(1)); // 1st
        assertEquals(2,cache.get(2)); // 2nd

        cache.put(3, 3); // insertted. (2, 2) should be removed.
        assertEquals(2,cache.get(2)); // 1st
        assertEquals(3,cache.get(3)); // 2nd

        assertNull(cache.get(1));
    }

    @Test
    public void testLRUCacheHighLevel() {
        LRUCacheHighLevel<Integer, String> cache = new LRUCacheHighLevel<>(2);

        cache.put(1, "A"); // only one and first
        cache.put(2, "B"); // become first. (1, 1) second
        assertEquals("A",cache.get(1)); // 1-A
        assertEquals("B",cache.get(2)); // 2-B

        cache.put(3, "C"); // 3-C
        assertEquals("B",cache.get(2)); // 1st
        assertEquals("C",cache.get(3)); // 2nd
        assertNull(cache.get(1));
    }

    @Test
    public void testLRUCache() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "A"); // only one and first
        cache.put(2, "B"); // become first. (1, 1) second
        assertEquals("A",cache.get(1)); // 1-A
        assertEquals("B",cache.get(2)); // 2-B
        cache.printMe();

        cache.put(3, "C"); // 3-C
        assertEquals("B",cache.get(2)); // 1st
        assertEquals("C",cache.get(3)); // 2nd
        assertNull(cache.get(1));
        cache.printMe();
        cache.get(2);
        cache.printMe();
        cache.put(5, "E");
        cache.printMe();
    }
}