package com.oth.test;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author anyanwen
 * @Date 2017/3/29.
 */
public class InstanceTest {
	private static class Config{
	}

	private static class WsConfig extends Config {
	}

	private static class Result{
		private Config config;

		public Config getConfig() {
			return config;
		}

		public void setConfig(Config config) {
			this.config = config;
		}
	}

	private static class WsResult extends Result{

	}

	public static void main(String[] args) {
		WsResult wsResult = new WsResult();
		wsResult.setConfig(new WsConfig());


		Config config = wsResult.getConfig();
		System.out.println(config instanceof WsConfig);
		System.out.println(config instanceof Config);
		System.out.println(TimeUnit.SECONDS.toMillis(4));;
	}
}
