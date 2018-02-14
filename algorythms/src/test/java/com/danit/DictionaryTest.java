package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {
  @Test
  public void test() {
    assertEquals("a: 1\n" +
        "aa: 2\n" +
        "b: 1\n" +
        "bb: 2\n" +
        "c: 1\n" +
        "cc: 1\n" +
        "d: 1\n",
        new Dictionary().main("a b c aa bb cc d aa bb"));
  }
  @Test
  public void test2() {
    assertEquals("a1: 1\n" +
            "aa: 2\n" +
            "b: 1\n" +
            "bb: 2\n" +
            "c: 1\n" +
            "cc: 1\n" +
            "d: 1\n",
        new Dictionary().main("a1 b c aa bb cc d aa bb"));
  }

  @Test
  public void test3() {
    assertEquals("a1: 1\n" +
            "aa: 2\n" +
            "b: 1\n" +
            "bb: 2\n" +
            "c: 1\n" +
            "cc: 1\n" +
            "d: 1\n",
        new Dictionary().main2("a1 b c aa bb cc d aa bb"));
  }
  @Test
  public void testAdd1() {
    //assertEquals(2, new Dictionary().add(1,1));
  }

  @Test
  public void testAdd2() {
    float f1 = 0.3F;
    float f2 = 0.4F;
    System.out.println(f1 + f2);
  }

}