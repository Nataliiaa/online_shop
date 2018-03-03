package com.danit;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TaskOrderV2recursive {

    public static class Graph {
        int E, V;
        Set<Integer>[] adjacent;

        Graph(int V) {
            this.V = V;
            adjacent = new Set[V];
            for (int i = 0; i < adjacent.length; i++) {
                adjacent[i] = new HashSet<Integer>();
            }
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void add(int u, int v) {
            if (!adjacent[u].contains(v)) {
                E++;
                adjacent[u].add(v);
            }
        }

        public Integer[] adj(int v) {
            Integer[] vertices = new Integer[adjacent[v].size()];
            return adjacent[v].toArray(vertices);
        }

    }

    public static Graph readGraph(Scanner in) {
        int V = in.nextInt();
        int E = in.nextInt();
        Graph graph = new Graph(V);
        for (int i = 0; i < E; i++) {
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static void topologycalSort(Graph graph){
        boolean visited[]  = new boolean[graph.V()];
        Stack<Integer> stack = new Stack<>();
        topologycalSort(graph, visited,0, stack);
        stack.push(0);

        System.out.print(stack.pop());
        while(!stack.isEmpty()){
            System.out.printf(" %d",stack.pop());
        }
    }

    public static void topologycalSort(Graph DG, boolean visited[], int v,  Stack<Integer> stack){
        for(int u : DG.adj(v)){
            if(!visited[u]){
                visited[u] = true;
                topologycalSort(DG, visited, u, stack);
                stack.push(u);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String input = "4 6\n" +
                "0 2\n" +
                "0 3\n" +
                "0 1\n" +
                "1 3\n" +
                "1 2\n" +
                "3 2";
        Graph graph =  readGraph(new Scanner(input));
        topologycalSort(graph);
    }
}
