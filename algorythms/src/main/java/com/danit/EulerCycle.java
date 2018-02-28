package com.danit;

import java.util.*;

public class EulerCycle {

    public static UndirectedGraph readGraph(ScannerFromString in){
        int V = in.nextInt(), E = in.nextInt();
        UndirectedGraph graph = new UndirectedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static void main(String[] args) {
        String input = "3 4\n" +
                "0 2\n" +
                "1 2\n" +
                "1 1\n" +
                "2 2";
        ScannerFromString in = new ScannerFromString(input);
        //Scanner in = new Scanner(System.in);
        UndirectedGraph graph = readGraph(in);
        int count = 0;

        for (int i = 0; i < graph.V(); i++) {
            int degree = 0;

            for (int adj : graph.adj(i)) {

                if (adj != i) {
                    degree++;
                }
            }

            if (degree % 2 == 1) {
                count++;

                if (count > 2) {
                    System.out.println("not Eulerian");
                    return;
                }
            }
        }

        System.out.println(count == 0 ? "Eulerian" : "Semi-Eulerian");

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
