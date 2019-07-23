package com.zw.singleton;

public class SingletonLazy {
	public static void main(String[] args) {
		President ps1 = President.getInstance() ;
		ps1.getName();
		President ps2 = President.getInstance() ;
		ps2.getName();
		if(ps1 == ps2) {
			System.out.println("他们是同一个人");
		}else {
			System.out.println("他们不是同一个人");
		}
	}
}
	class President{
		private static volatile President instance = null ;
	    private President() {
	    	System.out.println("产生一个总统");
	    }
	   	public static synchronized President getInstance() {
	   		if(instance == null ) {
	   			instance = new President() ;
	   		}else {
	   			System.out.println("已经有一个总统，不能再产生一个总统！");
	   		}
	   		return instance ;
	    }
	   	public void getName() {
	   		System.out.println("我是美国总统普朗克");
	   	}
}


