package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CuboidTest {
  @Test
  public void testCuboidSet1() {
    assertEquals(
        "315",
        new Cuboid().main("24 3 5 5 7 7 3 4 4 9 5 7 1 1 9 9 1 3 5 3 4 4 7 1 9")
    );
  }
}