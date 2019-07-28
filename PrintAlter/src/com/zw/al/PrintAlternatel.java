package com.zw.al;

public class PrintAlternatel {
	private static class Counter{
		public int value = 1 ;
		public boolean ood = true ;
	}
	private static Counter counter = new Counter() ;
	private static class PrintOdd implements Runnable{

		@Override
		public void run() {
			while(counter.value <= 100) {
				synchronized(counter) {
					if(counter.ood) {
						System.out.println("线程A:"+counter.value);
						counter.value++;
						counter.ood = !counter.ood ;
						counter.notify();
					}
					else {
						try {
							counter.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
			
		}
		
	}
	private static class PrintEvev implements Runnable{

		@Override
		public void run() {
			while(counter.value <= 100) {
				synchronized(counter) {
					if(counter.ood) {
						try {
							counter.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						System.out.println("线程B:"+counter.value);
						counter.value++;
						counter.ood = !counter.ood ;
						counter.notify();
					}
				}
				
			}
			
		}
	}

	public static void main(String[] args) {
		new Thread(new PrintOdd()).start() ;
		new Thread(new PrintEvev()).start() ;

	}

}
