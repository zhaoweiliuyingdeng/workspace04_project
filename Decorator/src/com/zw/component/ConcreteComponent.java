package com.zw.component;

public class ConcreteComponent implements Component {
	public ConcreteComponent() {
		System.out.println("创建了具体构件");
	}

	@Override
	public void operation() {
		System.out.println("调用了具体构件的operation方法");
	}

}
