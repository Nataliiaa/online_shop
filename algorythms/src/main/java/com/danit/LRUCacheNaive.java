package com.danit;

public class LRUCacheNaive {
    int[] values;
    final int capacity;

    public LRUCacheNaive(int capacity) {
        this.capacity = capacity;
        values = new int[capacity];
    }

    public void put(int key, int val) {
        values[key % values.length] = val;
    }

    public int get(int key) {
        return values[key % values.length];
    }
}
