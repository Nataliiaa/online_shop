package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraAlgorithmBaseTest {
    @Test
    public void testDijkstraAlgorithmDistanceOnly() {
        int from = 0;
        int to = 1;
        DijkstraAlgorithmBase d = new DijkstraAlgorithmBase();

        System.out.printf("Distance from %s to %s is %d km\n",
                d.name(from), d.name(to), d.solution(from, to)
        );
    }
}