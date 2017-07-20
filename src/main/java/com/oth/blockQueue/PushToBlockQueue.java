package com.oth.blockQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * by anyanwen
 * 2017/4/21.
 */
public class PushToBlockQueue {
	public static void main(String[] args) {
		KpiBase kpi = new KpiBase();
		LinkedBlockingQueue<KpiBase> kpiList = new LinkedBlockingQueue<>();
		long nanoStart = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			KpiBase kpiBase  = kpi.clone();
			try {
				kpiList.put(kpiBase);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long nanoEnd = System.nanoTime();
		System.out.println(TimeUnit.NANOSECONDS.toMillis(nanoEnd - nanoStart));
		int i = 0;
		nanoStart = System.nanoTime();
		while (!kpiList.isEmpty()) {
			try {
				KpiBase kpiBase = kpiList.take();
				kpi.calc(kpiBase);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		nanoEnd = System.nanoTime();
		System.out.println(TimeUnit.NANOSECONDS.toMillis(nanoEnd - nanoStart) + "=>" + i);
	}
}
