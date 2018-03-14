package com.danit;

import java.util.*;

public class DisjointSet {
    private int[] sets;

    public DisjointSet(int count) {
        sets = new int[count];
        for (int i = 0; i < count; i++) {
            sets[i] = i;
        }
    }

    public int countSets() {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < this.sets.length; i++) {
            sets.add(root(i));
        }
        return sets.size();
    }

    public Map<Integer, Integer> setIslandAndQty() {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < sets.length; i++) {
            int island = root(i);
            int qty = map.getOrDefault(island, 0);
            map.put(island, ++qty);
        }

        return map;
    }

    void add(int from, int to) {
        int rootTo = root(to);
        int rootFrom = root(from);
        sets[rootFrom] = rootTo;
    }

    void cancel(int from, int to) {
        if (from==to) { return; }
        int rootTo = root(to);
        int rootFrom = root(from);
        if (rootFrom==from) { sets[to]=to; }
        if (rootTo==to) { sets[from]=from; }
    }

    private int root(int item) {
        while (item != sets[item]){
            item = sets[item];
        }
        return item;
    }

    boolean check(int from, int to) {
        return root(from) == root(to);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%11s ", "sets[i]:"));
        for (int i = 0; i < sets.length; i++) {
            sb.append(String.format("%3d ", sets[i]));
        }
        sb.append(String.format("\n%11s ", "i :"));
        for (int i = 0; i < sets.length; i++) {
            sb.append(String.format("%3d ", i));
        }
        return sb.toString();
    }
}
