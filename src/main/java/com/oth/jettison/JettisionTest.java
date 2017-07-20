package com.oth.jettison;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.Iterator;

/**
 * @Description
 * @Author anyanwen
 * @Date 2017/2/21.
 */
public class JettisionTest {
	public static void main(String[] args) {
		String array = "{\"ff808081593c1e5c01593acefbec0011\":[{\"kpiid\":\"12301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"10\":\"60\"}]},{\"kpiid\":\"10301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"4\":\"60\"}]},{\"kpiid\":\"11301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"1\":\"60\"}]}],\"ff808081593c1e5c01593acefbec0010\":[{\"kpiid\":\"12301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"10\":\"60\"}]},{\"kpiid\":\"10301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"4\":\"60\"}]},{\"kpiid\":\"11301\",\"kpiname\":\"Avg90ResponseTime\",\"kpiactioninfos\":[{\"1\":\"60\"}]}]}";
		try {
			JSONObject jsonObject = new JSONObject(array);
			Iterator scripts = jsonObject.keys();
			while (scripts.hasNext()) {
				String scriptId = (String) scripts.next();
				JSONArray kpis = (JSONArray) jsonObject.get(scriptId);
				System.out.println(kpis.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private static void replaceValue() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("key", "value");
			jsonObject.put("key", "value1");
			System.out.println(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
