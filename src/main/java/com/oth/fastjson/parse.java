package com.oth.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * by anyanwen
 * 2017/4/19.
 */
public class parse {
	public static void main(String[] args) {
		String configJsonStr = args[0];
		JSONObject confJson = JSONObject.parseObject(configJsonStr);
	}
}
