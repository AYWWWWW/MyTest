package com.oth.howmanyN;


/**
 * by anyanwen
 * 一个自然数n，求0-n之间一共包含多少个2
 * 如：1-30之间有2,12,20-29，一共13个
 * 分别计算个位，十位，百位等上面2的个数，个位每10里面有一个2，十位每100里有10个2，百位每1000里有100个2，以此类推。。
 * 另外，当有余数的时候，如123%100 = 23, 那么这100-123个数还需要额外计算120,121,122,123 一共4个十位的2。
 * 2017/6/5.
 */
public class Main {
	private static final int N = 3;

	public static void main(String[] args) {
		int count = new Main().countN(1204);
		System.out.println(count);
	}

	private int countN(int num) {
		int count = 0;
		int union = 10;
		while (num / union != 0) {
			count += num / 10;//计算除数
			count = getRemainderCount(num, count, union);//计算余数
			num -= num % union;
			union *= 10;
		}
		count = getRemainderCount(num, count, union);
		return count;
	}

	private int getRemainderCount(int num, int count, int union) {
		if (num % union != 0) {
			if ((num % union) - N * union / 10 > 0) {
				if (num % union - (N + 1) * union / 10 > 0) {
					count += union / 10;
				} else {
					count += num % union - 2 * union / 10;
				}
			}
		}
		return count;
	}
}
