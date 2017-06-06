package com.division;

/**
 * by anyanwen
 * 2017/6/5.
 */
public class BiggestSumSubArray {
	public static void main(String[] args) {
		int[] array = {1,2,-3,-5,2,0,6,-5,8,6,-12,24,-22,2,4};
		new BiggestSumSubArray().division(array);
	}

	private void division(int[] array) {
		int curbegin = 0, begin = 0, end = 0;
		int b = 0, sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (b > 0) {
				b += array[i];
			} else {
				b = array[i];
				curbegin = i;
			}
			if (b > sum) {
				begin = curbegin;
				end = i;
				sum = b;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("biggest summary subarray result : \r\n[");
		for (int i = begin; i <= end; i++) {
			sb.append(array[i]).append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(", "));
		sb.append("]\r\nsum = ").append(sum);
		System.out.println(sb.toString());
	}
}
