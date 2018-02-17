package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
  @Test
  public void addOneElement() {
    BST bst = new BST();
    bst.add(5);
    assertTrue(bst.contains(5));
    assertFalse(bst.contains(1));
  }

  @Test
  public void addMoreThanOneElement() {
    int[] elements = {5, 3, 9, 2, 7, 11};
    int[] missed = {6, 8, 20, 12};
    BST bst = new BST();
    for (int el : elements) {
      bst.add(el);
    }
    for (int el : elements) {
      assertTrue(bst.contains(el));
    }
    for (int el : missed) {
      assertFalse(bst.contains(el));
    }
  }

  @Test
  public void removeElements() {
    int[] elements = {5, 3, 9, 2, 7, 11};
    int[] toRemove = {3, 2};
    BST bst = new BST();
    // add elements
    for (int el : elements) {
      bst.add(el);
    }
    // check elements
    for (int el : elements) {
      assertTrue(bst.contains(el));
    }
    // remove elements
    for (int el : toRemove) {
      bst.remove(el);
    }
    // check removed elements
    for (int el : toRemove) {
      assertFalse(bst.contains(el));
    }
  }
}