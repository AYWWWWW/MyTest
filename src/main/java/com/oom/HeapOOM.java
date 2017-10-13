package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args:-Xms20M -Xmx20m
 * created by anyanwen on 2017/10/13.
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
