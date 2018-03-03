package com.danit;
import java.util.*;

public class ShortestPath {

    public static class WeightedGraph {
        private int V,E;
        private int[][] weights;

        WeightedGraph(int V){
            this.V = V;
            this.E = 0;
            weights = new int[V][V];
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public void add(int u, int v, int weight){
            if(weights[u][v] == 0) E++;
            weights[u][v] = weight;
            weights[v][u] = weight;
        }

        public Integer[] adj(int v){
            List<Integer> adjacent = new ArrayList<>();
            for(int u = 0; u < V; u++){
                if(weights[v][u] != 0) adjacent.add(u);
            }
            Integer[] vertices = new Integer[adjacent.size()];
            return adjacent.toArray(vertices);
        }

        public int weight(int v, int u){
            return weights[v][u] != 0 ? weights[v][u] : Integer.MAX_VALUE;
        }
    }

    public static WeightedGraph readGraph(Scanner in){
        int V = in.nextInt();
        int E = in.nextInt();
        WeightedGraph graph = new WeightedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static WeightedGraph readGraph(ScannerFromString in){
        int V = in.nextInt();
        int E = in.nextInt();
        WeightedGraph graph = new WeightedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt(), in.nextInt());
        }
        return graph;
    }

    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WeightedGraph graph = readGraph(in);
        // read test values
        int N = in.nextInt();
        int citiesQty = graph.V();
        int[][] tests = new int[N][2];

        for(int i = 0; i < N; i++){
            tests[i][0] = in.nextInt();
            tests[i][1] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int v = tests[i][0];
            int u = tests[i][1];
            System.out.println(solution_distance(graph, v, u, citiesQty));
        }
    }

    public static void relax(WeightedGraph graph, Queue<Integer> pq, int[] distTo, int[] fromCity) {
        while(!pq.isEmpty()) {
            int currCityId = pq.poll();

            for (int city : graph.adj(currCityId)) {
                if (distTo[currCityId] < distTo[city] - graph.weight(city, currCityId)) {
                    distTo[city] = distTo[currCityId] + graph.weight(city, currCityId);
                    // path
                    fromCity[city] = currCityId;
                    pq.add(city);
                }
            }
        }
    }

    public static int solution_distance(WeightedGraph graph, int from, int to, int citiesQty) {
        int[] fromCity = new int[citiesQty];
        int[] distTo = new int[citiesQty];
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(city -> distTo[city]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
        }

        pq.add(from);
        relax(graph, pq, distTo, fromCity);

        return (distTo[to] == INF) ? -1 : distTo[to];
    }
}