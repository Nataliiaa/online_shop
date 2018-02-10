package com.danit;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfIntegerSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> queueMin = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>();

        while (in.hasNext()) {
            int number = in.nextInt();
            if (queueMin.isEmpty() || queueMax.peek() > number) {
                queueMin.add(number);
            } else {
                queueMax.add(number);
            }


            while (queueMax.size() > queueMin.size()) {
                queueMin.add(queueMax.poll());
            }

            while (queueMax.size() < queueMin.size()) {
                queueMax.add(queueMin.poll());
            }

            if (queueMax.size() != queueMin.size()){
                if (queueMax.size() > queueMin.size()){
                    System.out.print(queueMax.peek());
                }
                else {
                    System.out.print(queueMin.peek());
                }
            }
            else {
                System.out.print((queueMax.peek()+queueMin.peek())/2 );

            }

            System.out.print(" ");

        }


    }
}
