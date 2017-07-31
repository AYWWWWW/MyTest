package com.mt.tpxx;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.mt.tpxx.heap.FixedSizePriorityQueue;

/**
 * created by anyanwen on 2017/7/14.
 */
public class TPXXTest {
    private static final int TOTAL = 1000000;
    private List<Long> modelList = new ArrayList<>(TOTAL);

    @Before
    public void init() {
        Random random = new SecureRandom();
        long max = 0, l = 0;
        for (int i = 0; i < TOTAL; i++) {
            l = Math.abs(random.nextLong()) % 3000;
            modelList.add(l);
            max = max > l ? max : l;
        }
        System.out.println(max);
    }

    @Test
    public void testSpeedBetweenTDigestAndPriorityQueue() {
        long start = 0L, interval = 0L;

        start = System.nanoTime();
        int size1 = 10000;
        FixedSizePriorityQueue<Long> fixedQueue1 = new FixedSizePriorityQueue<>((int)(size1 * 0.1f));
        for (int i = 0; i < size1; i++) {
            fixedQueue1.add(modelList.get(i));
        }
        interval = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        System.out.println("the tp90 of " + size1 + " is " + fixedQueue1.peek() + " and takes " + interval + "ms");
        System.out.println("the list size is " + fixedQueue1.sortedList().size() + " and list is " + fixedQueue1.sortedList());

        int size2 = 100000;
        FixedSizePriorityQueue<Long> fixedQueue2 = new FixedSizePriorityQueue<>(size2 / 10);
        for (int i = 0; i < size2; i++) {
            fixedQueue2.add(modelList.get(i));
        }
        interval = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        System.out.println("the tp90 of " + size2 + " is " + fixedQueue2.peek() + " and takes " + interval + "ms");

        int size3 = 1000000;
        FixedSizePriorityQueue<Long> fixedQueue3 = new FixedSizePriorityQueue<>(size3 / 1);
        for (int i = 0; i < size3; i++) {
            fixedQueue3.add(modelList.get(i));
        }
        interval = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        System.out.println("the tp90 of " + size3 + " is " + fixedQueue3.peek() + " and takes " + interval + "ms");
    }
}
