package com.danit;

import java.util.*;
import java.util.ArrayList;

public class PaintBFS {

    private static int[][] picture = {
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 1, 0, 0}
    };

    static class Point{
        int x;
        int y;

        public Point(int coordX, int coordY){
            x = coordX;
            y = coordY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    public static List<Point> getNeighbours(Point p){
        List<Point> points = new ArrayList<>();

        if (p.x >= 1){
            points.add(new Point(p.x - 1, p.y));
        }
        if (p.x < picture.length - 1){
            points.add(new Point(p.x + 1, p.y));
        }
        if (p.y >= 1){
            points.add(new Point(p.x, p.y - 1));
        }
        if (p.y < picture[p.x].length - 1){
            points.add(new Point(p.x, p.y + 1));
        }
        return points;
    }

    public static boolean inFrame(int pixel, Point p){
        return picture[p.x][p.y] == pixel;
    }

    public static void main(String[] args) {
        Point clickedpoint = new Point(1, 5);
        Queue<Point> queue = new LinkedList<>();
        Set<Point> marked = new HashSet<>();

        queue.add(clickedpoint);
        int pixel = picture[clickedpoint.x][clickedpoint.y];
        while (!queue.isEmpty()){
            Point current =  queue.poll();
            for(Point neighbour : getNeighbours(current)){
                if (inFrame(pixel, neighbour) && !marked.contains(neighbour)){
                    marked.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println(marked.size());

        for (Point p : marked){
            picture[p.x][p.y] = 2;
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                System.out.print(picture[i][j]);
            }
            System.out.println();
        }
    }


}
