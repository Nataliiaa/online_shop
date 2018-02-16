package com.danit;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScannerFromStringTest {

    @Test
    public void testScannerFromStringBadDesign() {
        ScannerFromString s = new ScannerFromString("a b c d e");
        while (s.hasNext()) {
            System.out.println(s.hasNext()+":"+s.next());
        }
        System.out.println(s.hasNext());
    }

    @Test
    public void testScannerFromStringGoodDesign() {
        ScannerFromString in = new ScannerFromString("a b c d e");
        StringBuilder sb = new StringBuilder();

        while (in.hasNext()) {
            sb.append(in.hasNext())
                .append(":")
                .append(in.next())
                .append("\n");
        }
        sb.append(in.hasNext())
            .append("\n");

        assertEquals(
            "true:a\n" +
            "true:b\n" +
            "true:c\n" +
            "true:d\n" +
            "true:e\n" +
            "false\n",
            sb.toString());
    }
}