package com.leetcode;

/**
 * @Description
 * @Author anyanwen
 * @Date 2017/3/23.
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("ab", ".*c"));
	}

	private static boolean isMatch(String s, String p) {
		if (!p.contains("*") && p.length() < s.length()) {
			return false;
		}
		int match = 0, i = 0, j = 0;
		while (j < p.length() && i < s.length()) {
			if (p.charAt(j) != '.' && p.charAt(j) != '*' && s.charAt(i) != p.charAt(j)) {
				j++;
			} else if (p.charAt(j) != '*') {
				i++;
				j++;
				match++;
			} else {
				while (i > 0 && i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
					i++;
					match++;
				}
				j++;
			}
		}
		return match == s.length();
	}
}
