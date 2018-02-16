package com.danit;

import java.util.stream.Stream;

public class ScannerFromString {
    private final String[] items;
    private int currPos =0;

    public ScannerFromString(String origin) {
        this.items = origin.split(" ");
    }

    public boolean hasNext() {
        return currPos <this.items.length;
    }

    public String next() {
        return this.items[currPos++];
    }

    public Stream<String> stream() {
        return Stream.of(this.items);
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
