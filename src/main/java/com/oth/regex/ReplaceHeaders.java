package com.oth.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * by anyanwen
 * 2017/4/28.
 */
public class ReplaceHeaders {

	private static String headers = "HTTP/1.1 101 Switching Protocols\r\n" +
			"Upgrade:websocket\r\n" +
			"Connection:Upgrade\r\n" +
			"sec-websocket-accept:5rI4XyMOMldVSDtlLwNeH+vTtRQ=\r\n" +
			"Sec-WebSocket-Accept:4324234+vTtRQ=\r\n" +
			"Sec-WebSocket-Accept:123123+vTtRQ=\r\n" +
			"Content-Length:0\r\n";

	public static void main(String[] args) {
		String right = "\\r\\n";
		Pattern pattern = Pattern.compile("Sec-WebSocket-Accept:(.*?)" + right);
		Matcher matcher = pattern.matcher(headers);
		if (matcher.find()) {
			headers = headers.replace(matcher.group(1), "helloworld");
		}
		System.out.println(headers);
	}
}
