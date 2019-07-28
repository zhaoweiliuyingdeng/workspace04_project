package com.zw.printer;

public class PrinterEven implements Runnable {
	@Override
	public void run() {
		for(int i = 1 ; i <= 100; i++) {
			if(1 % 2 != 0) {
				notify() ;
				System.out.println("线程B打印奇数"+i);
				
			}else {
				System.out.println("切换工作线程");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
