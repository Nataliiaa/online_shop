package com.danit;

public class BinaryHeap {

    private int[] array = new int[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(int number) {
        array[++size] = number;
        swim(size);
    }

    public int remove() {
        int firstElement = array[1];
        array[1] = array[size--];
        down(1);
        return firstElement;
    }

    private void swim(int index) {
        while (array[index / 2] < array[index] && index > 1) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void down(int index) {
        int child = index * 2;
        while (index * 2 < size) {
            child = index*2;
            if (child + 1 <= size && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[index]) {
                swap(child, index);
                index =child;
            }


        }
    }


}
