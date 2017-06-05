package com.callshell;

import java.io.IOException;

/**
 * @Author OneAPM
 * @Date 2017/1/18.
 * @Description
 */
public class CallShell {
	private static void callScript(String path, String cmd, String ips){
		String command = path + " " + cmd + " "+ ips;
		System.out.println("command:"+ command);
		try {
			Process process = Runtime.getRuntime().exec(command);
			int exitValue = process.waitFor();
			if (exitValue != 0) {
				System.err.println("Failed to call shell's command and the return status's is: " + exitValue);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String path = "/oneapm/local/test_httpclient_bind_ip/cptSetIp.sh";
		String cmd = args[0];
		String ips = args[1];
		callScript(path,cmd,ips);
	}
}
