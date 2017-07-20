package com.oth.fraction;

/**
 * by anyanwen
 * 2017/6/6.
 */
public final class MathUtil {

	public static int getCommonDiv(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int r = a % b;
		while (r!= 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static int getCommonMulti(int a, int b) {
		 return a * b / getCommonDiv(a, b);
	}
}
