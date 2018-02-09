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
}
