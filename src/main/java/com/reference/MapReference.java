package com.reference;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * by anyanwen
 * 2017/5/4.
 */
public class MapReference {
	final static Map<String , String > m1 = new HashMap<>();
	final static Map<String , String > m2 = new HashMap<>();
	public static void main(String[] args) {
		m1.put("1", "2");
		m1.put("2", "3");
		m1.forEach(m2::put);
		m1.clear();
		System.out.println(m2);
		long nanoTime = 0;
		for (int i = 0; i < 10; ) {
			if (nanoTime == 0) {//第一条直接发送，以后每隔200ms发送一次
				nanoTime = System.nanoTime();
				System.out.println(System.currentTimeMillis());
			} else if (System.nanoTime() - nanoTime > TimeUnit.MILLISECONDS.toNanos(1000)) {
				System.out.println(System.currentTimeMillis());
				nanoTime = System.nanoTime();
				i++;
			}
		}
	}
}
