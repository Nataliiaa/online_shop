package com.danit;


import java.util.*;

public class Cuboid {
    public String main(String origin) {
        // for codegym
        //Scanner in = new Scanner(System.in);
        // for IDEA
        ScannerFromString in = new ScannerFromString(origin);

        Map<Integer, Integer> sides = new HashMap<>();
        Queue<Integer> max = new PriorityQueue<>((n1, n2)->n2-n1);

        // read the count
        int N = in.nextInt();

        for (int i=0; i<N; i++){
            //read the side length
            int side = in.nextInt();
            Integer count = sides.getOrDefault(side, 0);
            // put the side into collection
            sides.put(side, ++count);

            if(count == 4) {
                max.add(side);
                sides.remove(side);
            }
        }

        int result = max.size()<3 ? -1 : max.poll() * max.poll() * max.poll() ;

        // print for codegym
        System.out.println(result);
        // return for tests within IDEA
        return String.valueOf(result);
    }
}
