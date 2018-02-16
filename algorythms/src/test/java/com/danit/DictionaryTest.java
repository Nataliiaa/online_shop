package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void testThatDictionaryMethodMainWorksCorrectly1() {
        assertEquals("a: 1\n" +
                "aa: 2\n" +
                "b: 1\n" +
                "bb: 2\n" +
                "c: 1\n" +
                "cc: 1\n" +
                "d: 1\n",
            new Dictionary().methodOne("a b c aa bb cc d aa bb"));
    }

    @Test
    public void testThatDictionaryMethodMainWorksCorrectly2() {
        assertEquals("a1: 1\n" +
                "aa: 2\n" +
                "b: 1\n" +
                "bb: 2\n" +
                "c: 1\n" +
                "cc: 1\n" +
                "d: 1\n",
            new Dictionary().methodOne("a1 b c aa bb cc d aa bb"));
    }

    @Test
    public void testThatDictionaryMethodMainV2WorksCorrectly() {
        assertEquals("a1: 1\n" +
                "aa: 2\n" +
                "b: 1\n" +
                "bb: 2\n" +
                "c: 1\n" +
                "cc: 1\n" +
                "d: 1\n",
            new Dictionary().methodTwo("a1 b c aa bb cc d aa bb"));
    }

    @Test
    public void testAdd2() {
        float f1 = 0.3F;
        float f2 = 0.4F;
        System.out.println(f1 + f2);
    }

}