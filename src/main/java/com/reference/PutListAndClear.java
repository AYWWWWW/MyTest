package com.reference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * by anyanwen
 * 2017/5/25.
 */
public class PutListAndClear {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		List<String> list1 = new ArrayList<>();
		list1.addAll(list);
		list.clear();
		list.forEach(System.out::println);
		list1.forEach(System.out::println);

	}
}
