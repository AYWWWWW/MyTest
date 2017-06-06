package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * by anyanwen
 * 2017/6/6.
 */
public class Solution {
	public static void main(String[] args) {
		new Solution().generateParenthesis(3);
	}

	public List<String> generateParenthesis(int n) {
		backtrack(new ArrayList<String>(), "", 0, 0, n);
		backtrackOptmise(new ArrayList<String>(), new char[2*n], n, 0,0,0);
		return null;
	}

	private void backtrackOptmise(ArrayList<String> strings, char[] cur, int n, int idx, int left, int right) {
		if (idx == n * 2) {
			strings.add(new String(cur));
			return;
		}
		if (left < n) {
			cur[idx] = '(';
			backtrackOptmise(strings, cur, n, idx + 1, left + 1, right);
		}
		if (right < left) {
			cur[idx] = ')';
			backtrackOptmise(strings, cur, n, idx + 1, left, right + 1);
		}

	}

	private List<String> backtrack(List<String> list, String str, int left, int right, int max) {
		if (left < max) {
			backtrack(list, str + "(", left + 1, right, max);
		}
		if (right < left) {
			backtrack(list, str + ")", left, right + 1, max);
		}
		if (str.length() == max * 2) {
			list.add(str);
		}
		return list;
	}
}
