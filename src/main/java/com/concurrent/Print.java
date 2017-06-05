package com.concurrent;

/**
 * by anyanwen
 * 2017/6/5.
 */
public class Print {
	private int i;

	public static void main(String[] args) {
		new Print().print();
	}

	private void print() {
		new Thread(new Add()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Sub()).start();
	}

	public int getInt() {
		return i;
	}

	public void setInt(int i) {
		this.i = i;
	}

	private class Add implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (Print.class) {
					setInt(getInt() + 1);
					System.out.println("thread-1 : " + getInt());
					Print.class.notifyAll();
					try {
						Print.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private class Sub implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (Print.class) {
					setInt(getInt() - 1);
					System.out.println("thread-2 : " + getInt());
					Print.class.notifyAll();
					try {
						Print.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
