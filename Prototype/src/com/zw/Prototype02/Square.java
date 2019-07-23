package com.zw.Prototype02;

import java.util.Scanner;

public class Square implements Shape{

	public Object clone() {
		Square s = null ;
		try {
			s = (Square)super.clone() ;
		} catch (Exception e) {
			System.out.println("拷贝正方形失败!");
		}
		return s ;
	}
	
	public void countArea() {
		int r = 0 ;
		System.out.println("这是一个正方形，请输入它的边长:");
		Scanner sc = new Scanner(System.in) ;
		r = sc.nextInt() ;
		System.out.println("正方形的面积为: "+r*r);
		
	}

}
