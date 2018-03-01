package com.danit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*
main idea given there
https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%94%D0%B5%D0%B9%D0%BA%D1%81%D1%82%D1%80%D0%B8
 */
public class DijkstraAlgorithmVerbosed {
    private final String[] names = {"Київ","Одеса","Вінниця","Львів","Тернопіль","Харків","Миколаїв","Запоріжжя"};
    private final int[] cities = {      0,      1,     2,       3,       4,         5,        6,          7};
    private final int[][] distances = {
            {   0,  -1, 266,  -1,  -1, 487,  -1, 568}, // 0
            {  -1,   0,  -1,  -1,  -1,  -1, 134, 487}, // 1
            { 266,  -1,   0, 369, 239,  -1,  -1,  -1}, // 2
            {  -1,  -1, 369,   0, 127,  -1,  -1,  -1}, // 3
            {  -1,  -1, 239, 127,   0,  -1,  -1,  -1}, // 4
            { 487,  -1,  -1,  -1,  -1,   0, 551, 303}, // 5
            {  -1, 134,  -1,  -1,  -1, 551,   0, 352}, // 6
            { 568, 487,  -1,  -1,  -1, 303, 352,   0}, // 7
            // 0    1    2    3    4    5    6    7
    };
    // if distances[i][j] == -1, that their cities don't connected directly.
    private final int citiesQty = cities.length;
    //private final int INF = Integer.MAX_VALUE;
    private final int INF = 9999;

    class Result {
        private final int distance;
        private final Stack<Integer> path;

        Result(int distance, Stack<Integer> path) {
            this.distance = distance;
            this.path = path;
        }

        public int distance() {
            return distance;
        }

        public Stack<Integer> path() {
            return path;
        }
    }

    public String name(int city) {
        return names[city];
    }

    Iterable<Integer> neighbours(int city){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < citiesQty; i++){
            if(distances[city][i] != -1) {
                list.add(i);
            }
        }
        return list;
    }

    String leftpad(String s, int count) {
        String s2="          "+s;
        return s2.substring(s2.length()-count);
    }

    String leftpad(int i, int count) {
        return leftpad(Integer.toString(i),count);
    }

    String leftpad(int i) {
        return leftpad(i, 10);
    }

    String leftpad(String s) {
        return leftpad(s, 10);
    }

    String collect(Stream<String> s) {
        return s.collect(Collectors.joining(","));
    }

    String intArrayToString(int[] a) {
        return collect(Arrays.stream(a).mapToObj(this::leftpad));
    }

    String strArrayToString(String[] a) {
        return collect(Arrays.stream(a).map(this::leftpad));
    }

    String queueToString(Queue<Integer> q) {
        return collect(q.stream().map(this::leftpad));
    }

    String queueMappedToNameToString(Queue<Integer> q) {
        return collect(q.stream().map(this::name).map(this::leftpad));
    }

    Stream<Integer> interableToStream(Iterable<Integer> iter) {
        return StreamSupport.stream(iter.spliterator(), false);
    }

    String intIterableToString(Iterable<Integer> neibs) {
        return collect(interableToStream(neibs).map(this::leftpad));
    }

    String intIterableMappedToNameToString(Iterable<Integer> neibs) {
        return collect(interableToStream(neibs).map(this::name).map(this::leftpad));
    }

    void printNameAndNeibhs(int city, Iterable<Integer> neibs) {
        String nameS = name(city);
        System.out.printf("Processing city:%s\n", nameS);
        System.out.printf("neibs to %s is: %s\n", nameS, intIterableToString(neibs));
        System.out.printf("neibs to %s is: %s\n", nameS, intIterableMappedToNameToString(neibs));
    }

    void printDistTo(String msg, int iter, int[] distTo) {
        System.out.printf("%s relax:%d,distTo%s\n",msg, iter, strArrayToString(names));
        System.out.printf("%s relax:%d,distTo%s\n", msg, iter, intArrayToString(distTo));
    }

    private void printQueue(int step, Queue<Integer> pq) {
        System.out.printf("step:%d, queue id's :%s\n",step,queueToString(pq));
        System.out.printf("step:%d, queue names:%s\n",step, queueMappedToNameToString(pq));
    }

    public void relax_distance(PriorityQueue<Integer> pq, int[] distTo){
        int currCityId = pq.poll();

        int iter=0;
        Iterable<Integer> neibs = neighbours(currCityId);
        printNameAndNeibhs(currCityId, neibs);

        for(int city : neibs) {
            printDistTo("before", iter, distTo);
            if (distTo[currCityId] + distances[currCityId][city] < distTo[city]) {
                distTo[city] =  distTo[currCityId] + distances[currCityId][city];
                //pq.remove(city);
                //pq.add(city);
                printDistTo("after ", iter, distTo);
            }
            iter++;
        }
    }

    public void relax_path(PriorityQueue<Integer> pq, int[] distTo, int[] fromCity) {
        int currCityId = pq.poll();
        int iter=0;
        Iterable<Integer> neibs = neighbours(currCityId);
        printNameAndNeibhs(currCityId, neibs);

        for (int city : neibs) {
            printDistTo("before", iter, distTo);
            if (distTo[currCityId] + distances[city][currCityId] < distTo[city]) {
                distTo[city] = distTo[currCityId] + distances[city][currCityId];
                fromCity[city] = currCityId;
                //pq.remove(city);
                //pq.add(city);
                printDistTo("after ", iter, distTo);
            }
            iter++;
        }
    }

    public int solution_distance(int from, int to) {
        int distTo[] = new int[citiesQty]; // empty array
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) ->Integer.compare(distTo[i1],distTo[i2]));

        // base initialization
        for(int i = 0; i < citiesQty; i++){
            // set 0 in source point, INF in others
            distTo[i] = (i == from) ? 0 : INF;
            // store in priority queue
            pq.add(i);
        }

        // do work
        int step=0;
        while(!pq.isEmpty()){
            printQueue(++step, pq);
            relax_distance(pq, distTo);
        }

        return distTo[to];
    }

    public Stack<Integer> solution_path(int from, int to) {
        int[] fromCity = new int[citiesQty];

        int distTo[] = new int[citiesQty];
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) ->Integer.compare(distTo[i1],distTo[i2]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
            pq.add(i);
        }

        while(!pq.isEmpty()){
            relax_path(pq, distTo, fromCity);
        }

        Stack<Integer> path = new Stack<>();
        path.push(to);
        while (path.peek() != from) {
            path.push(fromCity[path.peek()]);
        }
        return path;
    }

    public Result solution_smart(int from, int to) {
        int[] fromCity = new int[citiesQty];
        int distTo[] = new int[citiesQty];

/*
        // for those who want to use inner classes
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(distTo[i1], distTo[i2]);
            }
        });
*/

        // for those who want to write comparator by themselves
//        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer city1, Integer city2) ->Integer.compare(distTo[city1],distTo[city2]));

        // for those who want to be
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(city -> distTo[city]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
            pq.add(i);
        }

        int step=0;
        while(!pq.isEmpty()) {
            printQueue(++step, pq);
            relax_path(pq, distTo, fromCity);
        }

        Stack<Integer> path = new Stack<>();
        path.push(to);
        while (path.peek() != from) {
            path.push(fromCity[path.peek()]);
        }
        return new Result(distTo[to] ,path);
    }

    List<String> pathReadable(int from, int to) {
        return pathReadable(
                solution_path(from, to)
        );
    }

    List<String> pathReadable(Stack<Integer> path) {
        return path.stream()
                .map(integer -> names[integer])
                .collect(Collectors.toList());
    }

    // for those who want to understand how streams work
    List<String> pathReadableExplained(int from, int to) {
        Stack<Integer> path = solution_path(from, to);
        Stream<Integer> streamInts = path.stream();
        Stream<String> streamStrings = streamInts.map(integer -> names[integer]);
        List<String> list = streamStrings.collect(Collectors.toList());
        return list;
    }
}
