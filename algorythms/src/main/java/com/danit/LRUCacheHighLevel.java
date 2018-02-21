package com.danit;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheHighLevel<K, V> {
    private Map<K, V> lru;
    private final int capacity;
    private final boolean SORT_BY_ACCESS = true;
    private final float LOAD_FACTOR = 0.75F;

    public LRUCacheHighLevel(int capacity) {
        this.capacity = capacity;
        this.lru = new LinkedHashMap<>(capacity, LOAD_FACTOR, SORT_BY_ACCESS);
    }

    public V get(K k){
        return lru.get(k);
    }

    public void put(K k, V v){
        if (lru.containsKey(k)) {
            lru.remove(k);
        } else if (lru.size() >= capacity) {
            lru.remove(lru.keySet().iterator().next());
        }
        lru.put(k, v);
    }

    public void printSequence(){
        System.out.println(lru.keySet());
    }
}
