package com.danit;

import java.util.*;

public class KMax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        while(in.hasNext()) {
            int number = in.nextInt();
            queue.add(number);

            if (queue.size() > k)
                queue.poll();
        }

        System.out.println(queue.poll());
    }

}