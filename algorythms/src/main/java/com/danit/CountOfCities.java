package com.danit;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CountOfCities {

    public static UndirectedGraph readGraph(Scanner in){
        int V = in.nextInt(), E = in.nextInt();
        UndirectedGraph graph = new UndirectedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
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
    public static void main(String[] args) {
//        String input = "6 5\n" +
//                "0 1\n" +
//                "0 2\n" +
//                "1 2\n" +
//                "2 3\n" +
//                "4 5";
        String input = "20 7\n" +
                "1 13\n" +
                "1 17\n" +
                "2 9\n" +
                "2 13\n" +
                "3 6\n" +
                "7 12\n" +
                "7 10";
        ScannerFromString in = new ScannerFromString(input);
        //Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();

        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < E; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            ds.add(from, to);
        }

        Map<Integer, Integer> map = ds.setIslandAndQty();
        Queue<Integer> pq = new PriorityQueue<>();

        map.forEach((key, value) -> pq.add(value));

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }
}