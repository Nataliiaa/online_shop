package com.danit;

import java.util.*;

public class IsConnectedVerticesInGraph {

    public static UndirectedGraph readGraph(ScannerFromString in){
        int V = in.nextInt(), E = in.nextInt();
        UndirectedGraph graph = new UndirectedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    static String input = "6 5\n" +
            "0 1\n" +
            "0 2\n" +
            "1 2\n" +
            "2 3\n" +
            "4 5\n" +
            "3\n" +
            "1 3\n" +
            "2 4\n" +
            "4 5\n" +
            "\n";

    public static void main(String[] args) {
        ScannerFromString in = new ScannerFromString(input);
        UndirectedGraph graph = readGraph(in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            boolean[] visited = new boolean[graph.V()];
            if (dfs(graph, start, end, visited)){
                System.out.println("is connected");
            }
            else{
                System.out.println("isn't connected");
            }

        }



    }

    public static boolean dfs (UndirectedGraph graph, int start, int end, boolean[] visited){
        visited[start] = true;
        if (start == end)return true;

        for (int vertex : graph.adj(start)){
            if (!visited[vertex]){
                if (dfs(graph, vertex, end, visited)) return true;
            }
        }

        return false;
    }
    public static class UndirectedGraph {

        private int E,V;
        Set<Integer>[] adjacent;

        UndirectedGraph(int V){
            this.V = V;
            adjacent = new Set[V];
            for(int i = 0; i < adjacent.length; i++){
                adjacent[i] = new HashSet<Integer>();
            }
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public void add(int u, int v){
            validate(u);
            validate(v);

            if(!adjacent[u].contains(v)){
                E++;
                adjacent[u].add(v);
                adjacent[v].add(u);

            }
        }

        public Integer[] adj(int v){
            validate(v);
            Integer[] vertices = new Integer[adjacent[v].size()];
            return adjacent[v].toArray(vertices);
        }



        private void validate(int v){
            if(v >= V || v < 0) throw new IllegalArgumentException();
        }
    }
}