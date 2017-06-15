package com.uuid;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * by anyanwen
 * 2017/5/24.
 */
public class Uuid {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(65535000);
		for (int i = 0; i < 65535000; i++) {
			String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0,20);
			set.add(id);
		}
		System.out.println(set.size());
	}
}
