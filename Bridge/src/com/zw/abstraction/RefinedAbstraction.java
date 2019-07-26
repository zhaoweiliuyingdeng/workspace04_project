package com.zw.abstraction;

import com.zw.bridge.Implementor;

public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor imple) {
		super(imple);
		
	}

	@Override
	public void Operation() {
		System.out.println("扩展抽象化角色被访问");
		imple.OperationImpl();

	}

}
