package com.zw.thread;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("我继承了Thread类");
	}

}
