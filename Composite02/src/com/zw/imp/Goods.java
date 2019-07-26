package com.zw.imp;

import com.zw.aritile.Articles;

public class Goods implements Articles {
	private String name ;//名字
	private float unitPrice ;//单价
	private int quantity ;//数量
	public Goods(String name , int quantity , float unitPrice) {
		this.name = name ;
		this.quantity = quantity ;
		this.unitPrice = unitPrice ;
	}

	@Override
	public float calculation() {
		
		return quantity*unitPrice;
	}

	@Override
	public void show() {
		System.out.println("数量："+quantity+",单价："+unitPrice+"元");

	}

}
