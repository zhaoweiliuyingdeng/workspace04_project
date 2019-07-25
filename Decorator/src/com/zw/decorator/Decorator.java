package com.zw.decorator;

import com.zw.component.Component;

public class Decorator implements Component {
	private Component component ;
	public Decorator (Component component)
	{
		this.component = component ;
	}
	@Override
	public void operation() {
		component.operation();

	}

}
