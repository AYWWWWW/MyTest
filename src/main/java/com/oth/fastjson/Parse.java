package com.oth.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * by anyanwen
 * 2017/4/19.
 */
public class Parse {
	public static void main(String[] args) {
		String configJsonStr = "";
		JSONObject confJson = JSONObject.parseObject(configJsonStr);
		System.out.println(configJsonStr);
		String input = "";
		Parse parse = JSON.parseObject(input, new TypeReference<Parse>() {
		});
	}
}
