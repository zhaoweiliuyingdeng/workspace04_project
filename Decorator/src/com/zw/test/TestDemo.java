package com.zw.test;

import com.zw.component.Component;
import com.zw.component.ConcreteComponent;
import com.zw.decorator.ConcreteDecorator;

public class TestDemo {
	public static void main(String[] args) {
		Component c = new ConcreteComponent() ;
		c.operation();
		System.out.println("-------------------");
		Component cp = new ConcreteDecorator(c) ;
		cp.operation();
	}

}
