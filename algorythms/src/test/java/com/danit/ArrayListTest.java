package com.danit;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void verifyAddElementToArrayList() {
        ArrayList list = new ArrayList();
        int argValue = 3;
        list.add(argValue);
        int arrayIndex = 0;
        assertEquals(argValue, list.get(arrayIndex));
    }

    @Test
    public void verifyArrayListSize() {
        ArrayList list = new ArrayList();

        int argValue1 = 4;
        list.add(argValue1);
        int argValue2 = 5;
        list.add(argValue2);

        int arraySize = 2;
        assertEquals(arraySize, list.size());
    }

    @Test
    public void verifyArrayListResize() {
        ArrayList list = new ArrayList();
        int num = 15;

        for (int i = 0; i < num; i++) {
            list.add(i);
        }

        int expectedSize = 15;
        assertEquals(expectedSize, list.size());
    }

    @Test
    public void verifyArrayListRemoveLast() {
        ArrayList list = new ArrayList();
        int
    }
}
