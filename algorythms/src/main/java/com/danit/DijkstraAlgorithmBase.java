package com.danit;

import java.util.PriorityQueue;

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
        return list;
    }

    public void relax(PriorityQueue<Integer> pq, int[] distTo){
    }

    public int solution(int from, int to) {
        int distTo[] = new int[citiesQty]; // empty array

        System.out.println("not implemented yet");
        return distTo[to];
    }



}
