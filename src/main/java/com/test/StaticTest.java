package com.test;


import com.sun.javafx.collections.MappingChange;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author anyanwen
 * @Date 2017/3/30.
 */
public class StaticTest {

	public static InstanceTest NEWINSTANCE() {
		return new InstanceTest();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(NEWINSTANCE());
		}
		ConcurrentHashMap<String ,String > map = new ConcurrentHashMap<>();
		map.put("1","1");
		map.put("2","2");
		map.put("2","3");
		map.put("1","4");
		map.put("1","5");
		map.put("1","6");
		System.out.println(map);
	}
}
