package com.danit;

import java.util.Iterator;

public class ArrayListDan<T> implements Iterable<T> {
    private Object[] values;
    private int capacity = 10;
    private int size = 0;

    public ArrayListDan() {
        this.values = new Object[capacity];
    }

    public void add(T t) {

        if (size >= capacity) {
            resize();
        }

        this.values[size] = t;
        size++;
    }

    public T get(int index) {
        return (T) this.values[index];
    }

    public int size() {
        return this.size;
    }

    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("list is empty");
        }
        if (size <= capacity/4) {
            shrink();
        }
        this.size--;
    }

    private void shrink() {
        capacity /= 4;
        Object[] newArray = new Object[capacity];
        System.arraycopy(this.values, 0, newArray, 0, size);
        this.values = newArray;
    }

    private void resize() {
        this.capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(this.values, 0, newArray, 0, size);
        this.values = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return null;   //TODO to be added in nearest future
    }
}
