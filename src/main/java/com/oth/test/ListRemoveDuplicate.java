package com.oth.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author OneAPM
 * @Date 2017/2/14.
 * @Description
 */
public class ListRemoveDuplicate {
	public static void main(String[] args) {
		List<String> oriList = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		List<String> finalList;
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
		//remove within foreach!!
        //throws ConcurrentModificationException
        for (String s : finalList) {
            if (Objects.equals(s, "127.0.0.2")) {
                finalList.remove(s);
            }
        }
        System.out.println(finalList);
    }
}
