package com.callshell;

/**
 * @Author OneAPM
 * @Date 2017/1/18.
 * @Description
 */
public class CommandWaitForThread extends Thread {

	private Process process;
	private boolean finish = false;
	private int exitValue = -1;

	public CommandWaitForThread(Process process) {
		this.process = process;
	}

	public void run() {
		try {
			this.exitValue = process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			finish = true;
		}
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public int getExitValue() {
		return exitValue;
	}

}
