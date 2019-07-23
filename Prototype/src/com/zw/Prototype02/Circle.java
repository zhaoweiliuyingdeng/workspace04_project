package com.zw.Prototype02;

import java.util.Scanner;

public class Circle implements Shape{

	public void countArea() {
		int r = 0 ; 
		System.out.println("这是一个圆，请输入圆的半径：");
	    Scanner sc= new Scanner(System.in) ;
	    r = sc.nextInt() ;
	    System.out.println("圆的面积为: "+3.14*r*r);
		
	}

	
	public Object clone() {
		Circle c = null ;
		try {
			c = (Circle)super.clone() ;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("拷贝圆形失败!");
		}
		return c ;
	}

}
