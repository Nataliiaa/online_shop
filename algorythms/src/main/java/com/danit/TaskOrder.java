package com.danit;

import java.util.*;
import java.util.stream.Collectors;

public class TaskOrder {

    private static String intToStr(Integer n) {
        return Integer.toString(n);
    }

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


/*        public void remove(int u, int v) {
            if (adjacent[u].contains(v)) {
                adjacent[u].remove(v);
            }
        }*/


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

    public static String topologicalSort(Graph graph) {
        // Empty list that will contain the sorted elements
        ArrayList<Integer> L = new ArrayList<>();
        Set<Integer> S = findStarts(graph);
        while (!S.isEmpty()) {
            for (Integer nodeN : S) {
                S.remove(nodeN);
                L.add(nodeN);
                Integer[] nodesFromN = graph.adj(nodeN);
                for (Integer nodeM : nodesFromN) {
                    removeEdge(graph, nodeN, nodeM);
                    if (hasNoIncoming(graph, nodeM)) {
                        S.add(nodeM);
                    }
                }
            }
        }
        if (graphHasEdges(graph)) {
            return "graph has at least one cycle";
        } else {
            return L.stream().map(TaskOrder::intToStr).collect(Collectors.joining(" "));
        }
    }

    private static boolean hasNoIncoming(Graph graph, Integer nodeM) {
        for (int v = 0; v < graph.V; v++) {
            Integer[] vertex = graph.adj(v);
            for(Integer i  : vertex) {
                if (i == nodeM) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void removeEdge(Graph graph, Integer nodeN, Integer nodeM) {
        if (graph.adjacent[nodeN].contains(nodeM)) {
            graph.adjacent[nodeN].remove(nodeM);
            graph.E--;
        }
    }

    private static boolean graphHasEdges(Graph graph) {
        return graph.E > 0;
    }

    private static Set<Integer> findStarts(Graph graph) {
        HashSet<Integer> set = new HashSet<>();
        for (int v = 0; v < graph.V; v++) {
            if(hasNoIncoming(graph, v)) {
                set.add(v);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        String input = "4 6\n" +
                "0 2\n" +
                "0 3\n" +
                "0 1\n" +
                "1 3\n" +
                "1 2\n" +
                "3 2";

        Scanner in = new Scanner(input);
        Graph graph = readGraph(in);

        for (int i = 0; i < graph.V; i++) {
            System.out.printf("V:%d:",i);
            System.out.printf("[%s]\n", Arrays.stream(graph.adj(i)).map(x->Integer.toString(x)).collect(Collectors.joining(",")));
        }
        System.out.printf("Checking whether the Graph contains cycles: %s\n", hasCycles(graph));
        System.out.printf("Sorted:%s", topologicalSort(graph));
    }

    private static boolean hasCycles(Graph graph, int curVertex, boolean[] visited, HashSet<Integer> path) {
        visited[curVertex] = true;
        path.add(curVertex);
        for(int vertex : graph.adj(curVertex)) {
            if(!visited[vertex]) {
                if (hasCycles(graph, vertex, visited, path)){
                    return true;
                }
            } else if (path.contains(vertex)) {
                return true;
            }
        }
        path.remove(curVertex);
        return false;
    }

    private static boolean hasCycles(Graph graph) {
        boolean[] visited = new boolean[graph.V];
        HashSet<Integer> path = new HashSet<>();

        for (int i = 0; i < graph.V; i++) {
            if(!visited[i] && hasCycles(graph, i, visited, path)) {
                return true;
            }
        }
        return false;
    }
}
