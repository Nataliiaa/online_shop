package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisjointSetTest {

  @Test
  public void add() throws Exception {
    DisjointSet ds = new DisjointSet();

    ds.add(0,1);
    assertTrue(ds.check(0, 1));

    ds.cancel(0,1);
    assertFalse(ds.check(0, 1));
  }

  @Test
  public void disjointSetTest() throws Exception {
    DisjointSet ds = new DisjointSet();
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

}