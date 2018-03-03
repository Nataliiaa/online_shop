package com.danit;

import org.junit.Test;

import static com.danit.ShortestPath.readGraph;
import static com.danit.ShortestPath.solution_distance;
import static org.junit.Assert.*;

public class ShortestPathTest {

    @Test
    public void testShortestPathCodegym1() {
        String input = "6 9\n" +
                "0 1 2\n" +
                "0 2 6\n" +
                "1 2 4\n" +
                "1 4 8\n" +
                "1 3 7\n" +
                "2 4 3\n" +
                "3 4 4\n" +
                "3 5 5\n" +
                "4 5 12\n" +
                "3\n" +
                "1 5\n" +
                "2 4\n" +
                "4 5";
        int[] expected = {12, 3, 9};
        ScannerFromString in = new ScannerFromString(input);
        ShortestPath.WeightedGraph graph = readGraph(in);
        // read test values
        int N = in.nextInt();
        int citiesQty = graph.V();
        int[][] tests = new int[N][2];
        for(int i = 0; i < N; i++){
            tests[i][0]=in.nextInt();
            tests[i][1]=in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int v = tests[i][0];
            int u = tests[i][1];
            int result = solution_distance(graph, v, u, citiesQty);
            assertEquals(expected[i], result);
        }
    }

    @Test
    public void testShortestPathCodegym2() {
        String input = "16 12\n" +
                "0 12 9\n" +
                "2 14 10\n" +
                "3 15 9\n" +
                "5 13 2\n" +
                "6 15 9\n" +
                "6 7 1\n" +
                "7 11 3\n" +
                "8 14 7\n" +
                "9 13 10\n" +
                "9 12 3\n" +
                "10 14 4\n" +
                "10 15 10\n" +
                "3\n" +
                "11 7\n" +
                "1 12\n" +
                "3 10";
        int[] expected = {3, -1, 19};
        ScannerFromString in = new ScannerFromString(input);
        ShortestPath.WeightedGraph graph = readGraph(in);
        // read test values
        int N = in.nextInt();
        int citiesQty = graph.V();
        int[][] tests = new int[N][2];
        for(int i = 0; i < N; i++){
            tests[i][0]=in.nextInt();
            tests[i][1]=in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int v = tests[i][0];
            int u = tests[i][1];
            int result = solution_distance(graph, v, u, citiesQty);
            assertEquals(expected[i], result);
        }
    }

    @Test
    public void testShortestPathCodegym3() {
        String input = "15 21\n" +
                "0 5 8\n" +
                "0 13 3\n" +
                "0 6 2\n" +
                "1 4 7\n" +
                "1 7 9\n" +
                "1 9 7\n" +
                "2 11 5\n" +
                "2 10 1\n" +
                "2 6 3\n" +
                "3 11 1\n" +
                "4 14 1\n" +
                "4 10 7\n" +
                "4 6 5\n" +
                "4 9 8\n" +
                "5 11 9\n" +
                "5 9 1\n" +
                "6 12 2\n" +
                "6 9 4\n" +
                "7 10 5\n" +
                "10 13 1\n" +
                "11 12 8\n" +
                "12\n" +
                "10 4\n" +
                "1 11\n" +
                "14 10\n" +
                "14 14\n" +
                "6 10\n" +
                "3 6\n" +
                "14 7\n" +
                "7 8\n" +
                "6 4\n" +
                "4 7\n" +
                "8 8\n" +
                "11 14";
        int[] expected = {7, 17, 8, 0, 4, 9, 13, -1, 5, 12, 0, 14};
        ScannerFromString in = new ScannerFromString(input);
        ShortestPath.WeightedGraph graph = readGraph(in);
        // read test values
        int N = in.nextInt();
        int citiesQty = graph.V();
        int[][] tests = new int[N][2];
        for (int i = 0; i < N; i++) {
            tests[i][0] = in.nextInt();
            tests[i][1] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int v = tests[i][0];
            int u = tests[i][1];
            int result = solution_distance(graph, v, u, citiesQty);
            assertEquals(expected[i], result);
        }
    }
}