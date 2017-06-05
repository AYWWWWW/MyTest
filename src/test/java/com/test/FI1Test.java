package com.test;

import com.FI.FI1;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anyanwen on 2016/11/28 14:16.
 */
public class FI1Test {
    private FI1 fi ;

    public FI1Test() {
        fi = new FI1();
    }

    @Test
    public void testFIAndStream() {
//        System.out.println("filter: ");
//        fi.useStreamFilter();
//        System.out.println("sort: ");
//        fi.useStreamSort();
//        System.out.println("map: ");
//        fi.useStreamMap();
//        System.out.println("predicate: ");
//        fi.useStreamReduce();
        fi.useParallelStreamSort();
    }
}