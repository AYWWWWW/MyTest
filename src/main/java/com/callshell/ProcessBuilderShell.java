package com.callshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author OneAPM
 * @Date 2017/1/19.
 * @Description
 */
public class ProcessBuilderShell {

	public static List<byte[]> callShell(String cmd, String param1, String param2) {
		ProcessBuilder processBuilder = new ProcessBuilder(cmd, param1, param2);
		int runningStatus = 0;
		String s = null;
		List<byte[]> localAddressList = new ArrayList<>();
		try {
			Process p = processBuilder.start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
				localAddressList.add(getAddress2Byte(s));
			}
			while ((s = stdError.readLine()) != null) {
				System.err.println(s);
			}
			try {
				runningStatus = p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (runningStatus != 0) {
			System.out.println("执行失败，code:" + runningStatus);
		}
		return localAddressList;
	}

	static byte[] getAddress2Byte(String ipStr) {
		byte[] localAddress = new byte[4];
		String[] ip = ipStr.split("\\.");
		try {
			for (int i = 0; i < ip.length; i++) {
				localAddress[i] = (byte) (Integer.valueOf(ip[i]).intValue());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return localAddress;
	}


	public static void main(String[] args) {
		List<byte[]> localAddressList = callShell("/oneapm/local/test_httpclient_bind_ip/cptSetIp.sh", args[0], args[1]);
		for (byte[] bytes : localAddressList) {
			try {
				System.out.println("设置的IP为：" +
						InetAddress.getByAddress(bytes));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		String by = "10.128.8.5";
		getAddress2Byte(by);
	}

}