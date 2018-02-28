package com.danit;

import org.junit.Test;

public class DijkstraAlgorithmBaseTest {
    @Test
    public void testDijkstraAlgorithmDistanceOnly() {
        int from = 0;
        int to = 1;
        System.out.println("Distance only:");
        DijkstraAlgorithmBase d = new DijkstraAlgorithmBase();

        System.out.printf("Distance from %s to %s is %d km\n",
                d.name(from), d.name(to), d.solution(from, to)
        );
    }

    @Test
    public void testDijkstraAlgorithmDistancePath() {
        int from = 0;
        int to = 1;
        DijkstraAlgorithmBase d = new DijkstraAlgorithmBase();

        System.out.println("\nDistance+Path:");
        System.out.printf("Distance from %s to %s is %d km\n",
                d.name(from), d.name(to), d.solution(from, to)
        );
        System.out.printf("Path from %s to %s is %s\n",
                d.name(from), d.name(to), d.pathReadable(from, to)
        );

    }
}