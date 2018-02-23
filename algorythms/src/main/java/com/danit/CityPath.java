package com.danit;

import java.util.Stack;

public class CityPath {

    final static String[] cities = {
            "Київ", "Житомир", "Лубни", "Бориспіль", "Фастів", "Ніжин",  "Умань", "Суми", "Хмельницький", "Миколаїв"   };
             // 0       1          2        3            4         5         6        7       8               9

    final static int[][] roads = {
/* 0 Київ  */    { 1, 5, 7, 8, 9 }, // індекси міст з якими сполучений Київ
/* 1 Житомир */  { 0, 2, 8 }, // міста з'днані з Житомиром
/* 2 Лубни */    { 4, 9 },
/* 3 Бориспіль */{ 2, 5 },
/* 4 Фастів */   { 9 },
/* 5 Ніжин */    { 0, 3 },
/* 6 Умань */    { 8, 9 },
/* 7 Суми */     { 0, 2, 6 },
/* 8 Хмельн. */  { 6 },
/* 9 Миколаїв */ { 2, 6 }
    };

    public static void main(String[] args) {

        int startCity = 4;
        int endCity = 0;
        int[] from = new int[cities.length];

        for (int i = 0; i < from.length; i++) {
            from[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[cities.length];

        stack.add(startCity);
        visited[startCity] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int city : roads[current]) {
                if (!visited[city]) {
                    stack.add(city);
                    visited[city] = true;
                    from[city] = current;
                }
            }
        }
        System.out.printf("From %s we can get to: ", cities[startCity]);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] && i != startCity) {
                System.out.print(cities[i] + " ");
            }
        }
        System.out.println();
        System.out.printf("From %s we can't get to: ", cities[startCity]);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print(cities[i] + " ");
            }
        }
        if (visited[endCity]) {
            Stack<Integer> path = new Stack<>();
            path.add(endCity);

            while (path.peek() != startCity) {
                path.add(from[path.peek()]);
            }

            System.out.println();
            System.out.printf("Path from %s to %s: ", cities[startCity], cities[endCity]);

            while (!path.isEmpty()) {
                System.out.print(cities[path.pop()] + " ");

            }
        }
        else {
            System.out.println();
            System.out.printf("Path from %s to %s doesn't exist!", cities[startCity], cities[endCity]);
        }

    }
}
