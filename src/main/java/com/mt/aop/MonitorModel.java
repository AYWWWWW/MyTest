package com.mt.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

/**
 * created by anyanwen on 2017/7/17.
 */
@Component
public class MonitorModel {
    private ConcurrentMap<String, List> map = new ConcurrentHashMap();

    public void add(String key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Integer>());
        }

        map.get(key).add(value);
        System.out.println(map);
    }
}
