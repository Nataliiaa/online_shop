package com.danit;

import org.junit.Test;

public class DijkstraAlgorithmVerbosedTest {
    @Test
    public void testDijkstraAlgorithmDistanceOnly() {
        int from = 0;
        int to = 1;
        System.out.println("Distance only:");
        DijkstraAlgorithmVerbosed d = new DijkstraAlgorithmVerbosed();

        System.out.printf("Distance from %s to %s is %d km\n",
                d.name(from), d.name(to), d.solution_distance(from, to)
        );
    }

    @Test
    public void testDijkstraAlgorithmDistanceAndPath() {
        int from = 0;
        int to = 1;
        DijkstraAlgorithmVerbosed d = new DijkstraAlgorithmVerbosed();
        DijkstraAlgorithmVerbosed.Result r = d.solution_smart(from, to);

        System.out.println("\nDistance+Path:");
        System.out.printf("Distance from %s to %s is %d km\n",
                d.name(from), d.name(to), r.distance()
        );
        System.out.printf("Path from %s to %s is %s\n",
                d.name(from), d.name(to), d.pathReadable(r.path())
        );

    }
}