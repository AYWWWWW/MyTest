package com.Encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author OneAPM
 * @Date 2016/12/28.
 * @Description
 */
public class TestEncode {

	public static void main(String[] args) {
		String name="海尔";
		try {
			String test1 = URLEncoder.encode(name,"UTF-8");
			String test2 = URLEncoder.encode(name,"GBK");
			String test3= URLEncoder.encode(name,"ISO8859-1");
			System.out.println(test1 + "----" + test2 + "------" + test3);
			String name1 = URLDecoder.decode(test1, "UTF-8");
			String name2 = URLDecoder.decode(test2, "GBK");
			String name3 = URLDecoder.decode(test3, "ISO8859-1");
			System.out.println(name1 + "----" + name2 + "------" + name3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
