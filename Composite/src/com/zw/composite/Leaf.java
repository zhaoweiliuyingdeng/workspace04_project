package com.zw.composite;

import com.zw.component.Component;

public class Leaf implements Component {
	private String name ;
	public Leaf (String name) {
		this.name = name ;
	}

	@Override
	public void add(Component c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Component c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Component gitChild(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void operation() {
		System.out.println("树叶"+name+"被访问");

	}

}
