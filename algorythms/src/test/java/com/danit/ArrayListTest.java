package com.danit;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void verifyAddElementToArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer argValue = 3;
        list.add(argValue);
        int arrayIndex = 0;
        assertEquals(argValue, list.get(arrayIndex));
    }

    @Test
    public void verifyArrayListSize() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int argValue1 = 4;
        list.add(argValue1);
        int argValue2 = 5;
        list.add(argValue2);

        int arraySize = 2;
        assertEquals(arraySize, list.size());
    }

    @Test
    public void verifyArrayListResize() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 15;

        for (int i = 0; i < num; i++) {
            list.add(i);
        }

        int expectedSize = 15;
        assertEquals(expectedSize, list.size());
    }

    @Test
    public void verifyArrayListRemoveLast() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeLast();
        int expectedResult = 2;
        assertEquals(expectedResult, list.size());
    }
}
