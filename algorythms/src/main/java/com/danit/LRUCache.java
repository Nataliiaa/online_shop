package com.danit;

import java.util.HashMap;

public class LRUCache<K, V> {
    class Node<T, U> {
        T key;
        U value;
        Node<T, U> prev;
        Node<T, U> next;

        public Node(Node<T, U> previous, Node<T, U> next, T key, U value){
            this.prev = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, Node<K, V>> cache;
    private Node<K, V> leastRU;
    private Node<K, V> mostRU;
    private int capacity;
    private int size;

    public LRUCache(int sz) {
        this.capacity = sz;
        this.size = 0;
        leastRU = new Node<K, V>(null, null, null, null);
        mostRU = leastRU;
        cache = new HashMap<>();
    }

    public V get(K key) {
        Node<K, V> nodeFromCache = cache.get(key);
        // no entry in cache
        if (nodeFromCache == null) {
            return null;
        }
        // if key is MRU leave the list as it is
        else if (nodeFromCache.key == mostRU.key) {
            return mostRU.value;
        }
        // Get the next and prev nodes
        Node<K, V> nextNode = nodeFromCache.next;
        Node<K, V> prevNode = nodeFromCache.prev;
        // if at the left-most, we update LRU
        if (nodeFromCache.key == leastRU.key){
            nextNode.prev = null;
            leastRU = nextNode;
        }
        // If we are in the middle, we need to update the items before and after our item
        else if (nodeFromCache.key != mostRU.key){
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Finally move our item to the MRU
        nodeFromCache.prev = mostRU;
        mostRU.next = nodeFromCache;
        mostRU = nodeFromCache;
        mostRU.next = null;
        return nodeFromCache.value;
    }

    public void put(K key, V value) {
        // exit if we are already in the cache
        if (cache.containsKey(key)) return;
        // put the new node at the right-most end of the linked-list
        Node<K, V> myNode = new Node<K, V>(mostRU, null, key, value);
        mostRU.next = myNode;
        cache.put(key, myNode);
        mostRU = myNode;
        // delete the left-most entry and update the LRU pointer
        if (size == capacity) {
            cache.remove(leastRU.key);
            leastRU = leastRU.next;
            leastRU.prev = null;
        } else {
            // size < capacity
            if (size == 0) {
                leastRU = myNode;
            }
            size++;
        }
    }

}
