package com.backtrack;

import java.util.*;

/**
 * by anyanwen
 * 2017/6/2.
 */
public class SubSets {
	private List<Integer> temp = new ArrayList<>();
	public static void main(String[] args) {
		int[] s = {1,2,3};
		List<List<Integer>> list = new SubSets().subSets(s);
		list.forEach(System.out::println);
	}

	private List<List<Integer>> subSets(int[] s) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(s, 0, result);
		return result;
	}

	private void dfs(int[] s, int i, List<List<Integer>> result) {
		if (i == s.length) {
			List<Integer> l = new ArrayList<>();
			l.addAll(temp);
			result.add(l);
			return;
		}
		temp.add(s[i]);
		dfs(s, i+1, result);
		temp.remove(temp.size()-1);
		dfs(s, i+1, result);
	}
}
