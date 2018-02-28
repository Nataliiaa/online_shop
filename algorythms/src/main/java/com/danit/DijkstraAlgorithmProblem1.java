package com.danit;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraAlgorithmProblem1 {
    public static void main(String[] args) {
        int N = 8;
        int[][] graph = new int[N][];
        graph[1] = new int[] {2, 3};
        graph[2] = new int[] {4, 5};
        graph[3] = new int[] {5, 6};
        graph[4] = new int[] {3, 5};
        graph[5] = new int[] {2, 7};
        graph[6] = new int[] {7};
        graph[7] = new int[] {};
        graph[0] = new int[] {};

        int[][] weight = new int[N][];
        weight[1] = new int[] {5, 10};
        weight[2] = new int[] {5, 13};
        weight[3] = new int[] {7,  7};
        weight[4] = new int[] {5,  7};
        weight[5] = new int[] {1,  2};
        weight[6] = new int[] {3};

        boolean[] visited = new boolean[N];
        int sum = 0;
        int[] distance = new int[N];

        Deque<Integer> stack = new LinkedList<>();
        PriorityQueue<City> minDistance = new PriorityQueue<>();
        minDistance.add(new City(0,1));
        visited[1] = true;

        while (!minDistance.isEmpty()) {
            City currentCity = minDistance.poll();
            int city = currentCity.destination;

            for (int i = 0; i < graph[city].length; i++) {
                int neighbourCity = graph[city][i];

                if (!visited[neighbourCity]) {
                    minDistance.add(new City(distance[neighbourCity], neighbourCity));
                    visited[neighbourCity] = true;
                }
                if (distance[neighbourCity] == 0) {
                    distance[neighbourCity] = distance[city] + weight[city][i];
                } else {
                    distance[neighbourCity] = Math.min(distance[city] + weight[city][i], distance[neighbourCity]);

                }
            }
        }
        System.out.println(distance[7]);
    }
    static class City implements Comparable<City>{
        int distance;
        int destination;

        public City(int distance, int destination) {
            this.distance = distance;
            this.destination = destination;
        }

        @Override
        public int compareTo(City o) {
            return distance - o.distance;
        }
    }
}
