package com.danit;

import java.util.Scanner;

public class HammingDistance {

    private static int hamming(int one, int two) {
        int differ = one ^ two;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += ((differ >> i) & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=in.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int ham = hamming(a[i], a[j]);
                sum += ham;
            }
        }
        System.out.print(sum);
    }
}
