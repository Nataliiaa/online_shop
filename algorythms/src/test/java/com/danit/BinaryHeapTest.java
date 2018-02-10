package com.danit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class BinaryHeapTest {

    @Test
    public void test1BinaryHeap() {
        Comparator<Integer> comparator = new IntegerMaxComparator();
        com.danit.BinaryHeap heap = new BinaryHeap(comparator);
        heap.add(4);
        heap.add(8);
        heap.add(3);
        heap.add(1);

        Assert.assertEquals(4, heap.size());
    }

    @Test
    public void testBinaryHeapRemove() {
        Comparator<Integer> comparator = new IntegerMaxComparator();
        com.danit.BinaryHeap heap = new BinaryHeap(comparator);
        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.add(5);

        Assert.assertEquals(5, heap.remove());
        Assert.assertEquals(3, heap.size());
        Assert.assertEquals(4, heap.remove());

    }

    @Test
    public void testCompareMin(){
        Comparator<Integer> comparator = new IntegereMinComparator();
        BinaryHeap heap = new BinaryHeap(comparator);
        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.add(5);

        Assert.assertEquals(2, heap.remove());
        Assert.assertEquals(3, heap.size());
        Assert.assertEquals(3, heap.remove());
    }

}
