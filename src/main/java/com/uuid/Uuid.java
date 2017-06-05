package com.uuid;

import java.util.UUID;

/**
 * by anyanwen
 * 2017/5/24.
 */
public class Uuid {
	public static void main(String[] args) {
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		System.out.println(id);
		System.out.println(id.getBytes().length);
	}
}
