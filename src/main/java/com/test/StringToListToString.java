package com.test;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author OneAPM
 * @Date 2017/2/9.
 * @Description
 */
public class StringToListToString {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("192.168.0.1");
//		list.add("192.168.0.2");
//		list.add("192.168.0.3");
//		list.add("192.168.0.4");
//		list.add("192.168.0.5");
//		list.add("192.168.0.6");
//		list.add("192.168.0.7");
//		list.add("192.168.0.8");
//		String str = list.toString();
//		List<String> stringList = new ArrayList<>();
//		String []strings = str.substring(1,str.length()-1).replace(" ","").split(",");
//		stringList = Arrays.asList(strings);
//		System.out.println(list.toString());
//		System.out.println(stringList.toString());
//		System.out.println(stringList.get(5));
		JSONObject jsonObject = new JSONObject();
		try {
			list.clear();
			jsonObject.put("virtualIP", list);
			jsonObject.put("useVirtualIP",true);
			String s = jsonObject.getString("virtualIP");
			s = s.substring(1, s.length() - 1).replace("\"","");
			String []strings = s.split(",");
			System.out.println(jsonObject.toString());
			List l = Arrays.asList(strings);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
