package com.danit;

public class DisjointSet {
  private final int airportCount;
  private int[] flights;

  public DisjointSet(int airportCount) {
    this.airportCount = airportCount;
    flights = new int[airportCount];

    for (int i = 0; i < airportCount; i++) {
      flights[i] = i;
    }

  }

  void add(int from, int to) {
    flights[from] = to;
  }

  void cancel(int from, int to) {
    flights[from] = from;
  }

  boolean check(int from, int to) {
    while(true) {
      if (from == to) {
        return true;
      }
      from = flights[from];
      if(flights[from] == from) {
        if(from == to)
          return true;
        else
          return false;
      }
    }
  }

}
