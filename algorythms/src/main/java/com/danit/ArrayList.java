package com.danit;

public class ArrayList {
    private int[] array;
    private int capacity = 10;
    private int size = 0;

    public ArrayList() {
        this.array = new int[capacity];
    }

    public void add(int value) {

        if (size >= capacity) {
            resize();
        }

        this.array[size] = value;
        size++;
    }

    public int get(int index) {
        return this.array[index];
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(this.array, 0, newArray, 0, size);
        this.array = newArray;
    }
}
