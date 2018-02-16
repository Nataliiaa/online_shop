package com.danit;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class DisjointSetTest {

  @Test
  public void add1() throws Exception {
    int airportCount = 5;
    DisjointSet ds = new DisjointSet(airportCount);

    ds.add(0, 1);
    assertTrue(ds.check(0, 1));

    ds.cancel(0, 1);
    assertFalse(ds.check(0, 1));
  }


  @Test
  public void add2() throws Exception {
    int airportCount = 5;
    DisjointSet ds = new DisjointSet(airportCount);

    ds.add(0, 1);
    assertTrue(ds.check(0, 1));

    ds.add(1, 2);
    assertTrue(ds.check(1, 2));

    assertTrue(ds.check(0, 2));
    assertFalse(ds.check(0, 3));
    assertFalse(ds.check(2, 0));
  }

  @Test
  public void disjointSetTest() throws Exception {
    int airportCount = 5;
    DisjointSet ds = new DisjointSet(airportCount);
    ds.add(0,1);
    System.out.println("0 and 1 now connected");
    ds.add(1,2);
    System.out.println("1 and 2 now connected");
    ds.add(0,2);
    System.out.println("0 and 2 now connected");
    ds.add(3,4);
    System.out.println("3 and 4 now connected");

    System.out.println("0 and 2 are " + ds.check(0, 2));
    System.out.println("0 and 3 are " + ds.check(0, 3));

    ds.cancel(0,2);
    System.out.println("0 and 2 are " + ds.check(0, 2));
    ds.cancel(1,2);
    System.out.println("1 and 2 are " + ds.check(1, 2));

  }

  @Test
  public void disjointSetTest2() {
    final int FROM=0;
    final int TO=1;
    String source = "5 4 " +
        "0 1 "+
        "1 2 "+
        "0 2 "+
        "3 4 ";
    String sCancelled = "2";

    ScannerFromString in = new ScannerFromString(source);
    //Scanner in = new Scanner(System.in);
    int A=in.nextInt();
    int F=in.nextInt();
    int[][] flights = new int[F][2];
    int counter=0;

    while (in.hasNext()) {
      flights[counter][FROM]=in.nextInt();
      flights[counter][TO]=in.nextInt();
      counter++;
    }

    ScannerFromString in2 = new ScannerFromString(sCancelled);
    boolean[] cancelled = new boolean[F];
    while (in2.hasNext()) {
      cancelled[in2.nextInt()]=true;
    }

    DisjointSet ds = new DisjointSet(A);
    for (int i = 0; i < flights.length ; i++) {
      ds.add(flights[i][FROM], flights[i][TO]);
    }



  }

}