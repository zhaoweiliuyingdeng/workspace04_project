package com.zw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread mythread = new MyThread() ;
		mythread.start();
		mythread.sleep(3000L);
		Thread mythread2 = new Thread(new RunnableTest()) ;
		mythread2.start();
		mythread2.sleep(3000L);
		Callable cb = new CallableTest() ;
		FutureTask<String> fu = new FutureTask(cb) ;
		ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(fu);
        try {
			System.out.println(fu.get());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        executorService.shutdown();
	}

}
