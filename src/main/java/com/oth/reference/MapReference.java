package com.oth.reference;

import java.util.HashMap;
import java.util.Map;

/**
 * by anyanwen
 * 2017/5/4.
 */
public class MapReference {
	final static Map<String , String > m1 = new HashMap<>();
	final static Map<String , String > m2 = new HashMap<>();
	final static Map<String , String > m3 = new HashMap<>();
	public static void main(String[] args) {
		m1.put("1", "2");
		m1.put("2", "3");
		m1.forEach(m2::put);
		m3.putAll(m1);
		m1.clear();
		System.out.println(m2);
		System.out.println(m3);
	}
}
