package com.danit;

import java.util.TreeMap;

public class BST {

  class Node {
    int value;
    Node left;
    Node right;

    public Node (int value) {
      this.value = value;
    }
  }

  private Node root = null;

  public void add(int value) {
    root = addr(value, root);
  }

  private Node addr(int value, Node current) {
    if (current == null) {
      return new Node(value);
    }
    if (value < current.value) {
      current.left = addr(value, current.left);
    } else {
      current.right = addr(value, current.right);
    }
    return current;
  }

  public boolean contains(int value) {
    return containsr(value, root);
  }

  private boolean containsr(int value, Node current) {
    if (current == null) {
      return false;
    }
    if (value < current.value) {
      return containsr(value, current.left);
    } else if (value > current.value) {
      return containsr(value, current.right);
    } else {
      // value == current.value
      return true;
    }
  }

  public void remove(int value) {
     root = remover(value, root);
  }

  private Node remover(int value, Node current) {
     if (current == null) {
       return null;
     }
     if (current.value < value) {
       current.right = remover(value, current.right);
     } else if (current.value > value) {
       current.left = remover(value, current.left);
     } else {
       // current.value == value
       if (current.left == null) return current.right;
       if (current.right == null) return current.left;
       Node temp = current;
       current = min(temp.right);
       current.right=deleteMin(temp.right);
       current.left=temp.left;
     }
    return current;
  }

  private Node min(Node current) {
    return current.left == null ? current : min(current.left);
  }

  private Node deleteMin(Node current) {
    if (current.left == null) {
      return current.right;
    }
    current.left = deleteMin(current.left);
    return current;
  }

}
