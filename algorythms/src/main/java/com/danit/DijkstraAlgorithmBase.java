package com.danit;

import java.util.*;
import java.util.stream.Collectors;

/*
main idea given there
https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%94%D0%B5%D0%B9%D0%BA%D1%81%D1%82%D1%80%D0%B8
 */
public class DijkstraAlgorithmBase {
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
    private final int INF = Integer.MAX_VALUE;

    public String name(int city) {
        return names[city];
    }

    Iterable<Integer> neighbours(int city){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < citiesQty; i++){
            if(distances[city][i] != -1) {
                list.add(i);
            }
        }
        return list;
    }

    public void relax(PriorityQueue<Integer> pq, int[] distTo){
        int currCity = pq.poll();

        for(int cityId : neighbours(currCity)) {
            if (distTo[cityId] > distTo[currCity] + distances[currCity][cityId]) {
                pq.remove(cityId);
                distTo[cityId] =  distTo[currCity] + distances[currCity][cityId];
                pq.add(cityId);
            }
        }
    }

    public void relax1(PriorityQueue<Integer> pq, int[] distTo, int[] fromCity) {
        int current = pq.poll();

        for (int city : neighbours(current)) {
            if (distTo[city] > distTo[current] + distances[city][current]) {
                pq.remove(city);
                distTo[city] = distTo[current] + distances[city][current];
                fromCity[city] = current;
                pq.add(city);
            }
        }
    }

    public int solution(int from, int to) {
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
        while(!pq.isEmpty()){
            System.out.println(pq);
            relax(pq, distTo);
        }

        return distTo[to];
    }

    public Stack<Integer> path(int from, int to) {
        int[] fromCity = new int[citiesQty];

        int distTo[] = new int[citiesQty];
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) ->Integer.compare(distTo[i1],distTo[i2]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
            pq.add(i);
        }

        while(!pq.isEmpty()){
            relax1(pq, distTo, fromCity);
        }

        Stack<Integer> path = new Stack<Integer>();
        path.push(to);
        while (path.peek() != from) {
            path.push(fromCity[path.peek()]);
        }
        return path;
    }

    List<String> pathReadable(int from, int to) {
        return path(from, to)
                .stream()
                .map(integer -> names[integer])
                .collect(Collectors.toList());
    }

}
