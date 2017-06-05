package com.reference;

import com.state.CloseState;

import java.util.concurrent.ConcurrentHashMap;

/**
 * by anyanwen
 * 2017/5/8.
 */
public class PutMap {

	private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		Thread c1 = new Thread(new Count());
		Thread c2 = new Thread(new Count());
		Thread c3 = new Thread(new Count());
		Thread p1 = new Thread(new Print());
		c1.start();
		c2.start();
		c3.start();
		p1.start();
	}

	private static class Count implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				map.put("123", 312);
			}
		}
	}

	private static class Print implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println((double)map.get("123") / 1024 / 1024);
			}
		}
	}
}
