package com.oth.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * by anyanwen
 * 2017/6/2.
 */
public class NQueens {
	private int[][] board;
	private int N;
	public static void main(String[] args) {
		int n = 8;
		List<String> result = new NQueens().solveNQueens(n);
	}

	private List<String> solveNQueens(int n) {
		board = new int[n][n];
		N = n;
		List<String> result = new ArrayList<>();
		dfs(0, result);
		return result;
	}

	private void dfs(int level, List<String> result) {
		if (level == N) {
			output(result);
		}
		else {
			for (int i = 0; i < N; i++) {
				if (check(level, i)) {
					board[level][i] = 1;
					dfs(level + 1, result);
					board[level][i] = 0;
				}
			}
		}
	}

	private boolean check(int row, int col) {
		if (row == 0) {
			return true;
		}
		return false;
	}

	private void output(List<String> result) {
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					sb.append("Q");
				} else {
					sb.append("*");
				}
			}
			result.add(sb.toString());
		}
	}
}
