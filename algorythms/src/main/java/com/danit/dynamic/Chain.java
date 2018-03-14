package com.danit.dynamic;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Chain {


    /**
     Given three links of length: 1m, 2m, 3m.
     How many ways exist to make a chain of length N.
     There is an infinite number of links each type.

     main idea is given here:
     https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
     */

    // naive version v1, recursive part (doesn't pass the codegym because of a time)
    public static int solve_recursive(int n) {
        if (n<0) return 0;
        if (n==0) return 1;
        return solve_recursive(n-1) + solve_recursive(n-2) + solve_recursive(n-3);
    }
    // naive version v1, main part (doesn't pass the codegym because of a time)
    public static void main_recursive(String[] args) {
        Scanner in = new Scanner(System.in);
        int N =in.nextInt();
        System.out.println(solve_recursive(N));
    }

    // dynamic version v2, there are all values N is supported, even 0..2
    public static void main_v2(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int answer;
        if (N<0) {
            answer=0;
        } else if (N==0) {
            answer=1;
        } else {
            int[] dynamic = new int[N+1];
            dynamic[0]=1;
            dynamic[1]=1;
            dynamic[2]=2;
            for (int idx=3; idx<=N; idx++) {
                dynamic[idx] = dynamic[idx-1] + dynamic[idx-2] + dynamic[idx-3];
            }
            answer=dynamic[N];
        }
        System.out.println(answer);
    }
    // dynamic version v2, there are all values N is supported, even 0..2
    public static void main_v2_stream(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int answer;
        if (N<0) {
            answer=0;
        } else if (N==0) {
            answer=1;
        } else {
            int[] dynamic = new int[N+1];
            dynamic[0]=1;
            dynamic[1]=1;
            dynamic[2]=2;
            IntStream.rangeClosed(3,N).forEach(idx -> dynamic[idx] = dynamic[idx-1] + dynamic[idx-2] + dynamic[idx-3]);
            answer=dynamic[N];
        }
        System.out.println(answer);
    }

    // shortest version v3, because codegym doesn't check all the values N<3
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] solution = new int[N+1];
        solution[0] = 1;
        solution[1] = 1;
        solution[2] = 2;
        for (int idx=3; idx<=N; idx++) {
            solution[idx] = solution[idx-1] + solution[idx-2] + solution[idx-3];
        }
        System.out.println(solution[N]);
    }
    // shortest version v3, because codegym doesn't check all the values N<3
    public static void main_v3_stream(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] solution = new int[N+1];
        solution[0] = 1;
        solution[1] = 1;
        solution[2] = 2;
        IntStream.rangeClosed(3, N).forEach(idx -> solution[idx] = solution[idx-1] + solution[idx-2] + solution[idx-3]);
        System.out.println(solution[N]);
    }
}

