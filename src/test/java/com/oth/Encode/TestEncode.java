package com.oth.Encode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author OneAPM
 * @Date 2016/12/28.
 * @Description
 */
public class TestEncode {

	@Test
	public void testEncode() {
		String name="海尔";
		try {
			System.out.println(URLEncoder.encode(name,"UTF-8"));
			System.out.println(URLEncoder.encode(name,"GBK"));
			System.out.println(URLEncoder.encode(name,"GB2312"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEncodeandDecode() {
		String name="海尔";
		String text = null;
		try {

			text = java.net.URLEncoder.encode(URLEncoder.encode(name,"ISO8859-1"),"utf-8");

			name = java.net.URLDecoder.decode(URLDecoder.decode(text,"ISO8859-1"),"utf-8");
			System.out.println(text + "===========" + name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
