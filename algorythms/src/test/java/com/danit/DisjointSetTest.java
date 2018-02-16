package com.danit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class DisjointSetTest {

    @Test
    public void addOneElement() throws Exception {
        int airportCount = 5;
        DisjointSet ds = new DisjointSet(airportCount);
        ds.add(0, 1);
        assertTrue(ds.check(0, 1));
    }

    @Test
    public void addMoreThanOneElements() throws Exception {
        int COUNT = 5;
        DisjointSet ds = new DisjointSet(COUNT);
        ds.add(0, 1);
        assertTrue(ds.check(0, 1));
        ds.add(1, 2);
        assertTrue(ds.check(1, 2));
        // BiDirectional checks are worked now
        assertTrue(ds.check(0, 2));
        assertTrue(ds.check(2, 0));
        // this items aren't connected
        assertFalse(ds.check(0, 3));
    }

    @Test
    public void addMoreElementsConsoleOutput() throws Exception {
        int airportCount = 5;
        DisjointSet ds = new DisjointSet(airportCount);
        ds.add(0,1);
        System.out.println("0 and 1 now connected");
        ds.add(1,2);
        System.out.println("1 and 2 now connected");
        ds.add(3,4);
        System.out.println("3 and 4 now connected");

        System.out.println("are 0 and 1 connected:" + ds.check(0, 1));
        System.out.println("are 0 and 2 connected:" + ds.check(0, 2));
        System.out.println("are 0 and 3 connected:" + ds.check(0, 3));
        System.out.println("are 4 and 3 connected:" + ds.check(4, 3));
    }

    @Test
    public void remoreMoreElementsConsoleOutput() throws Exception {
        int airportCount = 5;
        DisjointSet ds = new DisjointSet(airportCount);
        ds.add(0,1);
        System.out.println("0 and 1 now connected");
        ds.add(1,2);
        System.out.println("1 and 2 now connected");
        ds.add(3,4);
        System.out.println("3 and 4 now connected");
        System.out.println(ds); // our flights
        System.out.println(ds.countSets()); // sets count

        System.out.println("are 0 and 1 connected:" + ds.check(0, 1));
        System.out.println("are 1 and 2 connected:" + ds.check(1, 2));
        System.out.println("are 0 and 2 connected:" + ds.check(0, 2));

        System.out.println("are 0 and 3 connected:" + ds.check(0, 3));
        System.out.println("are 4 and 3 connected:" + ds.check(4, 3));

        ds.add(0,2);
        System.out.println("are 0 and 2 connected:" + ds.check(0, 2));
        ds.cancel(0,2);
        System.out.println("are 0 and 2 connected:" + ds.check(0, 2));
        System.out.println("are 1 and 2 connected:" + ds.check(1, 2));
        ds.cancel(1,2);
        System.out.println("are 1 and 2 connected:" + ds.check(1, 2));
    }

    @Test
    public void countSets() {
        DisjointSet ds = new DisjointSet(10);
        ds.add(1, 3);
        ds.add(3, 5);
        assertEquals(8, ds.countSets());
    }

    class CanceledFlights {
        private  int count(String input) {
            final int FROM=0;
            final int TO=1;
            Scanner in = new Scanner(input);
            int airportCount = in.nextInt();
            int flightCount = in.nextInt();
            int airStart = in.nextInt();
            int airFinish = in.nextInt();
            int[][] flights = new int[flightCount][2];
            // reading flights
            for (int i = 0; i < flightCount; i++) {
                flights[i][FROM] = in.nextInt();
                flights[i][TO] = in.nextInt();
            }
            int howManyCancelled = in.nextInt();
            boolean[] canceled = new boolean[flightCount];
            int[] canceledFlights = new int[howManyCancelled];
            // reading cancelled flights
            for (int i = 0; i < howManyCancelled; i++) {
                canceledFlights[i] = in.nextInt();
                canceled[canceledFlights[i]] = true;
            }
            DisjointSet ds = new DisjointSet(airportCount);
            // will put into DissointsSet only NON DELETED
            for (int i = 0; i < flights.length; i++) {
                if (!canceled[i]) {
                    ds.add(flights[i][FROM], flights[i][TO]);
                }
            }
            int result = howManyCancelled;
            Integer currentIndex;
            while (!ds.check(airStart, airFinish) && result >= 1) {
                result--;
                currentIndex = canceledFlights[result];
                int[] currentFlight = flights[currentIndex];
                System.out.printf("%d | Flight %2d between %d %d\n", result,
                    currentIndex, currentFlight[FROM], currentFlight[TO]);
                ds.add(currentFlight[FROM], currentFlight[TO]);
            }
            return result + 1;
        }
    }

    @Test
    public void cancelledFlightProblemTest() {
            String input = "" +
                "10 14 0 9 " +
                "0 4 " +
                "0 1 " +
                "0 3 " +
                "1 2 " +
                "3 2 " +
                "3 5 " +
                "4 5 " +
                "5 6 " + //
                "3 7 " + //
                "7 6 " +
                "7 9 " +
                "6 9 " +
                "6 8 " + //
                "8 9 " + //
                "4 " +
                "7 12 8 13";
            System.out.printf("Result : %d\n", new CanceledFlights().count(input));
    }
}