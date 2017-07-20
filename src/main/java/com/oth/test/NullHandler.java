package com.oth.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author OneAPM
 * @Date 2017/1/9.
 * @Description
 */
public class NullHandler {

	private static Map<Short, String> get12005(Map<Short, Integer> kpi_004, Map<Short, Integer> kpi_13407) {
		Map<Short, String> kpi_005 = new HashMap<>();
		for (Short key : kpi_004.keySet()) {
			if (kpi_13407.containsKey(key) && kpi_13407.get(key) != null &&
					kpi_004.containsKey(key) && kpi_004.get(key) != null) {
				double percent = (double) kpi_004.get(key) / (double) kpi_13407.get(key);
				kpi_005.put(key,percent + "");
			} else if (!kpi_004.containsKey(key) || kpi_004.get(key) == null) {
				kpi_005.put(key,"0");
			} else if (!kpi_13407.containsKey(key) || kpi_13407.get(key) == null) {
				kpi_005.put(key,"100");
			}
		}
		return kpi_005;
	}

	public static void main(String[] args) {
		Map<Short,Integer> kpi_004 = new HashMap<>();
		Map<Short,Integer> kpi_13407 = new HashMap<>();
		kpi_004.put((short)404,1);
		kpi_13407.put((short)404,0);
		Map<Short,String > kpi_005 = get12005(kpi_004,kpi_13407);
		for (Short aShort : kpi_005.keySet()) {
			System.out.println(kpi_005.get(aShort));
		}
	}
}
