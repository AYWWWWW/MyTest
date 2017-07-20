package com.oth.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * by anyanwen
 * 2017/6/5.
 */
public class ArraySum {
	private static final int SIZE = 16;
	private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 23, 23, 33, 22, 123, 43, 54, 65, 78, 32, 43, 123, 2, 3, 55, 32, 323, 54, 3, 231, 32,
			123, 32, 54, 78, 5, 4, 43, 23, 43, 67, 43, 32, 43, 21, 32, 12, 32, 54, 65, 87, 23, 1, 23, 43, 132, 34, 31, 23, 12, 32, 243, 32};

	public static void main(String[] args) {
		new ArraySum().sumArray();
	}

	private void sumArray() {
		int sum = 0;
		int num = array.length / SIZE;
		if (array.length % SIZE != 0) {
			num++;
		}
		List<Integer> res = new ArrayList<>(num);
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch doneLatch = new CountDownLatch(num);
		for (int i = 0; i < num; i++) {
			Thread t = new Thread(new addThread(i * SIZE,
					(i + 1) * SIZE < array.length ? (i + 1) * SIZE : array.length,
					startLatch, doneLatch, res));
			t.start();
		}
		startLatch.countDown();
		System.out.println("begin calc...");
		try {
			doneLatch.await();
			for (int i : res) {
				sum += i;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("calc end, result : " + sum);
	}

	public int[] getArray() {
		return array;
	}

	private class addThread implements Runnable {
		private int start, end;
		private CountDownLatch doneLatch;
		private CountDownLatch startLatch;
		private List<Integer> list;

		addThread(int start, int end, CountDownLatch startLatch, CountDownLatch doneLatch, List<Integer> res) {
			this.start = start;
			this.end = end;
			this.doneLatch = doneLatch;
			this.startLatch = startLatch;
			this.list = res;
		}

		@Override
		public void run() {
			try {
				startLatch.await();
				int sum = 0;
				int[] array = getArray();
				for (int i = start; i < end; i++) {
					sum += array[i];
				}
				synchronized (ArraySum.class) {
					list.add(sum);
					System.out.println("thread" + start + "-" + end + " calc :" + sum);
				}
				doneLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
