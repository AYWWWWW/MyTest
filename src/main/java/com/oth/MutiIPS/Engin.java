package com.oth.MutiIPS;

/**
 * @Author OneAPM
 * @Date 2017/1/16.
 * @Description
 */
public class Engin {
	public static void main(String[] args) {
		byte[] ip = {(byte) 10, (byte) 128,8, (byte) 211};
		for (int i = 214; i <= 216; i++) {
			ip[3] = (byte) i;
			LoaderThread loaderThread = new LoaderThread(ip);
			new Thread(loaderThread).start();
		}
	}
}
