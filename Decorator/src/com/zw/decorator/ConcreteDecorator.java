package com.zw.decorator;

import com.zw.component.Component;

public class ConcreteDecorator extends Decorator {

	public ConcreteDecorator(Component component) {
		super(component);
		
	}
	public void operation() {
		super.operation();
		addFunction() ;
		
	}
	public void addFunction() {
		System.out.println("增加了具体方法");
	}

}
