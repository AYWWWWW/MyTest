package com.oth.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * by anyanwen
 * 2017/5/16.
 */
public class RegCheck {
	public static void main(String[] args) {
		String left = "123121";
		String right = "$";
		String value = "123566789";
		String whreg = left + "(.*?)" + right;
		Pattern p = Pattern.compile(whreg);
		Matcher m = p.matcher(value);
		while (m.find())
			System.out.println(m.group(1));
	}
}
