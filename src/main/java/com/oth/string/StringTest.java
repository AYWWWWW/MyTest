package com.oth.string;

/**
 * by anyanwen
 * 2017/6/7.
 */
public class StringTest {
	public static void main(String[] args) {
		String ss1 = new StringBuilder("go")
				.append("od").toString();
		System.out.println(ss1.intern() == ss1);
		String ss2 = new StringBuilder("ja")
				.append("va").toString();
		System.out.println(ss2.intern() == ss2);

		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";
		String s6 = s3 + s4;
		System.out.println(s1 == s2);
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		System.out.println(s1 == s6.intern());
		System.out.println(s2 == s2.intern());
	}
}
