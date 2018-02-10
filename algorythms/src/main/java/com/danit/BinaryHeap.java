package com.danit;

import java.util.Comparator;

public class BinaryHeap<T> {

    private T[] array;
    private int size = 0;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        array = (T[]) new Object [10];
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public void add(T number) {
        array[++size] = number;
        swim(size);
    }

    public T remove() {
        T firstElement = array[1];
        array[1] = array[size--];
        down(1);
        return firstElement;
    }

    private void swim(int index) {
        while (index > 1 && comparator.compare(array[index / 2], array[index]) < 0) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void down(int index) {
        int child = index * 2;
        while (index * 2 < size) {
            child = index*2;
            if (child + 1 <= size && comparator.compare(array[child], array[child + 1]) < 0) {
                child++;
            }
            if (comparator.compare(array[child], array[index]) > 0) {
                swap(child, index);
                index =child;
            }


        }
    }


}
