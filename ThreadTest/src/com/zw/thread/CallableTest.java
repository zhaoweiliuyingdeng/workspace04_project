package com.zw.thread;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		return "我实现了Callable接口";
	}

}
