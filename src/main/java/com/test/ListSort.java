package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author anyanwen
 * @Date 2017/3/14.
 */
public class ListSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(8);
		list.sort(Integer::compareTo);
		System.out.println(list);
	}
}
