package com.zw.Test;

import com.zw.adapter.Motor;

public class TestDemo {
	public static void main(String[] args) {
		System.out.println("适配器模式测试");
		Motor m =(Motor) ReadXML.getObject();
		m.driver();
	}

}
