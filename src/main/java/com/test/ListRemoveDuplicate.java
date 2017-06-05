package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author OneAPM
 * @Date 2017/2/14.
 * @Description
 */
public class ListRemoveDuplicate {
	public static void main(String[] args) {
		List<String> oriList = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		List<String> finalList = new ArrayList<>();
		oriList.add("127.0.0.1");
		oriList.add("127.0.0.2");
		oriList.add("127.0.0.2");
		oriList.add("127.0.0.3");
		oriList.add("127.0.0.4");
		oriList.add("127.0.0.4");
		oriList.add("127.0.0.5");
		for (String s : oriList) {
			if (!tempList.contains(s)) {
				tempList.add(s);
			}
		}
		finalList = tempList;
		System.out.println(finalList);
	}
}
