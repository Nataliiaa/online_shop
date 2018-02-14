package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

  @Test
  public void testPutAndGet() throws Exception {
    HashMapDan map = new HashMapDan();
    map.put(123,500);
    map.put(15,600);
    map.put(11,700);
    map.put(223,800);

    assertEquals(500, map.get(123));
    assertEquals(600, map.get(15));
    assertEquals(700, map.get(11));
    assertEquals(800, map.get(223));
    assertEquals(-1, map.get(2));
  }

  @Test
  public void testPutFailure() throws Exception {
    HashMapDan map = new HashMapDan();
    map.put(1,501);
    map.put(1,502);
    map.put(3,503);
    map.put(4,504);
    map.put(5,505);
    map.put(6,506);
    map.put(7,507);
    map.put(8,508);
    map.put(9,509);
    map.put(10,510);
    map.put(11,511);
  }
}