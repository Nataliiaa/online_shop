package com.danit;

public class HashMapDan {
  int capacity=10;
  int[] keys = new int[capacity];
  int[] values = new int[capacity];

  private int hash(int key) {
    return key % capacity;
  }

  public void put(int key, int value) throws Exception {
    int index = hash(key);
    if (keys[index] == 0 || keys[index]==key) {
      keys[index] = key;
      values[index] = value;
    } else {
      for (int i = 0; i < capacity; i++) {
        if (keys[i] == 0 || keys[i]==key) {
          keys[i] = key;
          values[i] = value;
          return;
        }
      }
      throw new Exception();
    }
  }

  public int get(int key) {
    int index = hash(key);
    if (keys[index] == key) {
      return values[index];
    } else {
      for (int i = 0; i < capacity; i++) {
        if (keys[i] == key) {
          return values[i];
        }
      }
    }
    return -1;
  }
}

