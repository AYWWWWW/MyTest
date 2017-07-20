package com.oth.getaddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Author OneAPM
 * @Date 2017/2/7.
 * @Description
 */
public class Main {

	/**
	 * Get host IP address
	 *
	 * @return IP Address
	 */
	private static InetAddress getAddress() {
		try {
			for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
				NetworkInterface networkInterface = interfaces.nextElement();
				if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
					continue;
				}
				Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
				if (addresses.hasMoreElements()) {
					return addresses.nextElement();
				}
			}
		} catch (SocketException e) {
			System.out.println("Error when getting host ip address: <{}>."+ e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		InetAddress address = getAddress();
		System.out.println(address != null ? address.toString() : null);
	}
}
