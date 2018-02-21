package com.danit;

import java.util.HashMap;

public class LRUCache<K, V> {

    class Node<T, U> {
        private final T key;
        private final U value;
        Node<T, U> prev;
        Node<T, U> next;

        Node(Node<T, U> prev, Node<T, U> next, T key, U val){
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = val;
        }
    }

    private final HashMap<K, Node<K, V>> cache;
    private Node<K, V> least;
    private Node<K, V> most;
    private final int capacity;
    private int size;

    public LRUCache(int capa) {
        this.cache = new HashMap<>();
        this.capacity = capa;
        this.size = 0;
        this.least = new Node<K, V>(null, null, null, null);
        this.most = least;
    }

    public V get(K key) {
        // check whether our item in the cache
        Node<K, V> node = cache.get(key);
        // no entry in cache
        if (node == null) {
            return null;
        }
        // if key is MRU leave the list as it is
        if (node.key == most.key) {
            return most.value;
        }
        // now we have to reorder our cache (linked list)
        // next and prev nodes
        Node<K, V> next = node.next;
        Node<K, V> prev = node.prev;
        if (node.key == least.key) {
            // if left-most, we update the list and set new least
            next.prev = null;
            least = next;
        } else {
            // node.key != most.key
            // we are in the middle, we need to update the items before and after our item
            prev.next = next;
            next.prev = prev;
        }
        // set our node to the most (reorder list)
        node.prev = most;
        node.next = null;
        most.next = node;
        // update most
        most = node;
        return node.value;
    }

    public void put(K key, V value) {
        // exit if we are already in the cache
        if (cache.containsKey(key)) return;
        // put the new node at the right-most end of the linked-list
        Node<K, V> node = new Node<K, V>(most, null, key, value);
        most.next = node;
        cache.put(key, node);
        most = node;
        // delete the left-most entry and update the LRU pointer
        if (size == capacity) {
            cache.remove(least.key);
            least = least.next;
            least.prev = null;
        } else {
            // size < capacity
            if (size == 0) {
                least = node;
            }
            size++;
        }
    }

}
