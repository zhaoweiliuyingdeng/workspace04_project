package com.zw.printer;

public class Test {
	public static void main(String[] args) {
		Thread thread = new Thread(new PrinterEven()) ;
		Thread thread2 = new Thread(new PrinterOOD()) ;
		
		thread.start();
		thread2.start();

	}

}
