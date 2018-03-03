package com.danit;

import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < citiesQty; i++){
            if(distances[city][i] != -1) {
                list.add(i);
            }
        }
        return list;
    }

    public void relax(PriorityQueue<Integer> pq, int[] distTo, int[] fromCity) {
        int currCityId = pq.poll();

        for (int city : neighbours(currCityId)) {
            if (distTo[currCityId] + distances[city][currCityId] < distTo[city]) {
                distTo[city] = distTo[currCityId] + distances[city][currCityId];
                // path
                fromCity[city] = currCityId;
            }
        }
    }

    public int solution_distance(int from, int to) {
        int[] fromCity = new int[citiesQty];
        int distTo[] = new int[citiesQty];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(city -> distTo[city]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
            pq.add(i);
        }

        while(!pq.isEmpty()){
            relax(pq, distTo, fromCity);
        }
        return distTo[to];
    }

    public Stack<Integer> solution_path(int from, int to) {
        int[] fromCity = new int[citiesQty];
        int distTo[] = new int[citiesQty];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(city -> distTo[city]));

        for(int i = 0; i < citiesQty; i++){
            distTo[i] = (i == from) ? 0 : INF;
            pq.add(i);
        }

        while(!pq.isEmpty()){
            relax(pq, distTo, fromCity);
        }

        Stack<Integer> path = new Stack<>();
        path.push(to);
        while (path.peek() != from) {
            path.push(fromCity[path.peek()]);
        }
        return path;
    }

}
