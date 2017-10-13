package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * created by anyanwen on 2017/10/13.
 */
public class PermOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }
}
