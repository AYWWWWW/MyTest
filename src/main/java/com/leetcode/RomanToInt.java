package com.leetcode;

public class RomanToInt {
	private static byte[] order = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static int[] value = {1000, 500, 100, 50, 10, 5, 1};

	public static void main(String[] args) {
		String s = "DCXXI";
		System.out.println(romanToInt(s));
	}

	private static int romanToInt(String s) {
		return convert(s);
	}

	private static int convert(String s) {
		if (s == null || s.length() == 0) return 0;
		int idx;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			idx = getIndex(order, c);
			if (idx == -1) {
				continue;
			} else if (idx > 0) {
				return value[i] - convert(s.substring(0, idx)) + convert(s.substring(idx + 1));
			} else {
				return value[i] + convert(s.substring(idx + 1));
			}
		}
		return 0;
	}

	private static int getIndex(byte[] order, char c) {
		int idx = -1;
		for (int i = 0; i < order.length; i++) {
			if (c == order[i]) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}