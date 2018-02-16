package com.danit;

import java.util.HashSet;
import java.util.Set;

public class DisjointSet {
    private int[] flights;

    public DisjointSet(int airportCount) {
        flights = new int[airportCount];
        for (int i = 0; i < airportCount; i++) {
            flights[i] = i;
        }
    }

    public int countSets() {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < flights.length; i++) {
            sets.add(root(i));
        }
        return sets.size();
    }

    void add(int from, int to) {
        int rootTo = root(to);
        int rootFrom = root(from);
        flights[rootFrom] = rootTo;
    }

    void cancel(int from, int to) {
        if (from==to) { return; }
        int rootTo = root(to);
        int rootFrom = root(from);
        if (rootFrom==from) { flights[to]=to; }
        if (rootTo==to) { flights[from]=from; }
    }

    private int root(int item) {
        while (item != flights[item]){
            item = flights[item];
        }
        return item;
    }

    boolean check(int from, int to) {
        return root(from) == root(to);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%11s ", "flights[i]:"));
        for (int i = 0; i < flights.length; i++) {
            sb.append(String.format("%3d ", flights[i]));
        }
        sb.append(String.format("\n%11s ", "i :"));
        for (int i = 0; i < flights.length; i++) {
            sb.append(String.format("%3d ", i));
        }
        return sb.toString();
    }
}
