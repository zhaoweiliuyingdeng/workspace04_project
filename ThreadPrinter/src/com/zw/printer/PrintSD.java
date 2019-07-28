package com.zw.printer;

public class PrintSD {
	public synchronized void print(String str , int num) {
		notify() ;
		System.out.println(str+num);
		try {
            if(100 != num){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	 //奇数打印线程
    class Odd implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<100;i+=2){
                print("奇数:",i);
            }
        }
    }

    //偶数打印线程
    class Even implements Runnable{
        @Override
        public void run() {
            for(int i=2;i<=100;i+=2){
                print("偶数:",i);
            }
        }
    }

    public static void main(String[] args) {
        PrintSD p = new PrintSD();
        Odd odd = p.new Odd();
        Even even = p.new Even();
        new Thread(odd).start();
        new Thread(even).start();
    }


}
