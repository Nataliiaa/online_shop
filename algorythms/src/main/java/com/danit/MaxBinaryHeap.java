package com.danit;

import java.util.Scanner;

public class MaxBinaryHeap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] heap = new int[k + 1];

        for (int i = 1; i < k + 1; i++) {
            heap[i] = in.nextInt();
        }

        for (int i = 2; i < k + 1; i++) {
            if (heap[i] > heap[i / 2]) {
                System.out.println("isn't heap");
                return;
            }
        }

        System.out.println("is heap");
    }
}
