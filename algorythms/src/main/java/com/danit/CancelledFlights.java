package com.danit;
import java.util.*;

public class CancelledFlights {

    final static int FROM=0;
    final static int TO=1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int airportCount = in.nextInt();
        int flightCount = in.nextInt();
        Connections flights = new Connections(flightCount);

        // reading flights
        for (int i = 0; i < flightCount; i++) {
            int from  = in.nextInt();
            int to = in.nextInt();
            flights.add(from, to);
        }

        // executing 'check' and 'cancel' commands
        while (in.hasNext()) {
            String cmd = in.next();

            if ("cancel".equals(cmd)) {
                int flightID = in.nextInt();
                flights.delete(flightID);
                flightCount--;
            } else if ("check".equals(cmd)) {
                DisjointSet ds = dsFromConnections(airportCount, flights);
                int from = in.nextInt();
                int to = in.nextInt();
                System.out.println(ds.check(from, to));
            }
        }
    }

    private static DisjointSet dsFromConnections(int airportCount, Connections connections) {
        DisjointSet ds = new DisjointSet(airportCount);
        int[][] conn = connections.get();

        for (int i = 0; i < conn.length; i++) {
            ds.add(conn[i][FROM], conn[i][TO]);
        }

        return ds;
    }

    static class Connections {
        int[][] connections;
        int capacity;
        int size;
        final int FROM = 0;
        final int TO = 1;

        int[] deleted;
        final int DELETED = -1;
        int deletedCount = 0;

        Connections(int capacity) {
            connections = new int[capacity][2];
            deleted = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

        public void add(int from, int to) {
            connections[size][FROM] = from;
            connections[size][TO] = to;
            this.size++;
        }

        public int[][] get() {
            int[][] remainingConnections = new int[size - deletedCount][2];

            for (int i = 0, j = 0; i < size; i++) {

                if (deleted[i] != DELETED) {
                    remainingConnections[j][FROM] = connections[i][FROM];
                    remainingConnections[j][TO] = connections[i][TO];
                    j++;
                }
            }

            return remainingConnections;
        }

        public void delete(int id) {
            deleted[id] = DELETED;
            deletedCount++;
        }
    }

    static class DisjointSet {
        private int[] connection;

        public DisjointSet(int nodeCount) {
            connection = new int[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                connection[i] = i;
            }
        }

        public int countSets() {
            Set<Integer> sets = new HashSet<>();
            for (int i = 0; i < connection.length; i++) {
                sets.add(root(i));
            }
            return sets.size();
        }

        void add(int from, int to) {
            int rootTo = root(to);
            int rootFrom = root(from);
            connection[rootFrom] = rootTo;
        }

        void cancel(int from, int to) {
            if (from==to) { return; }
            int rootTo = root(to);
            int rootFrom = root(from);
            if (rootFrom==from) { connection[to]=to; }
            if (rootTo==to) { connection[from]=from; }
        }

        private int root(int item) {
            while (item != connection[item]){
                connection[item] = connection[connection[item]];
                item = connection[item];
            }
            return item;
        }

        boolean check(int from, int to) {
            return root(from) == root(to);
        }
    }

}