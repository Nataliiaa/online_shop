package com.danit;
import java.util.*;

public class CountOfCitiesCodegymImplementation {

    public static UndirectedGraph readGraph(Scanner in){
        int V = in.nextInt(), E = in.nextInt();
        UndirectedGraph graph = new UndirectedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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

    static class DisjointSet {
        private int[] sets;

        public DisjointSet(int count) {
            sets = new int[count];
            for (int i = 0; i < count; i++) {
                sets[i] = i;
            }
        }

        public int countSets() {
            Set<Integer> sets = new HashSet<>();
            for (int i = 0; i < this.sets.length; i++) {
                sets.add(root(i));
            }
            return sets.size();
        }

        public Map<Integer, Integer> setIslandAndQty() {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;

            for (int i = 0; i < sets.length; i++) {
                int island = root(i);
                int qty = map.getOrDefault(island, 0);
                map.put(island, ++qty);
            }

            return map;
        }

        void add(int from, int to) {
            int rootTo = root(to);
            int rootFrom = root(from);
            sets[rootFrom] = rootTo;
        }

        void cancel(int from, int to) {
            if (from==to) { return; }
            int rootTo = root(to);
            int rootFrom = root(from);
            if (rootFrom==from) { sets[to]=to; }
            if (rootTo==to) { sets[from]=from; }
        }

        private int root(int item) {
            while (item != sets[item]){
                item = sets[item];
            }
            return item;
        }

        boolean check(int from, int to) {
            return root(from) == root(to);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%11s ", "sets[i]:"));
            for (int i = 0; i < sets.length; i++) {
                sb.append(String.format("%3d ", sets[i]));
            }
            sb.append(String.format("\n%11s ", "i :"));
            for (int i = 0; i < sets.length; i++) {
                sb.append(String.format("%3d ", i));
            }
            return sb.toString();
        }
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