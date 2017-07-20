package com.oth.callshell; /**
 * @Author OneAPM
 * @Date 2017/1/18.
 * @Description
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ShellTest {

	public static void main(String[] args) {
		InputStreamReader stdISR = null;
		InputStreamReader errISR = null;
		Process process = null;
		String command = "/oneapm/local/test_httpclient_bind_ip/cptSetIp.sh " + args[0] + " 10.128.8.214-216/24";
		long timeout = 10 * 1000;
		try {
			process = Runtime.getRuntime().exec(command);

			CommandStreamGobbler errorGobbler = new CommandStreamGobbler(process.getErrorStream(), command, "ERR");
			CommandStreamGobbler outputGobbler = new CommandStreamGobbler(process.getInputStream(), command, "STD");

			errorGobbler.start();
			// 必须先等待错误输出ready再建立标准输出
			while (!errorGobbler.isReady()) {
				Thread.sleep(10);
			}
			outputGobbler.start();
			while (!outputGobbler.isReady()) {
				Thread.sleep(10);
			}

			CommandWaitForThread commandThread = new CommandWaitForThread(process);
			commandThread.start();

			long commandTime = new Date().getTime();
			long nowTime = new Date().getTime();
			boolean timeoutFlag = false;
			while (!commandThread.isFinish()) {
				if (nowTime - commandTime > timeout) {
					timeoutFlag = true;
					break;
				} else {
					Thread.sleep(1000);
					nowTime = new Date().getTime();
				}
			}
			if (timeoutFlag) {
				// 命令超时
				errorGobbler.setTimeout(1);
				outputGobbler.setTimeout(1);
				System.out.println("正式执行命令：" + command + "超时");
			}

			while (true) {
				if (errorGobbler.isReadFinish() && outputGobbler.isReadFinish()) {
					break;
				}
				Thread.sleep(10);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
	}
}
