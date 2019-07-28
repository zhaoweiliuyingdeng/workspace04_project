package com.zw.printer;

public class PrinterOOD implements Runnable {
	@Override
	public void run() {
		for(int i = 1 ; i <= 100 ; i++) {
			if(i % 2 == 0) {
				notify() ;
				System.out.println("线程A打印偶数："+i);
			}else {
				System.out.println("切换工作线程");
				try {
					wait() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
