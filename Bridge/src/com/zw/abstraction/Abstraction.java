package com.zw.abstraction;

import com.zw.bridge.Implementor;

public abstract class Abstraction {
	protected Implementor imple ;
	public Abstraction(Implementor imple) {
		this.imple = imple ;
	}
	public abstract void Operation() ;

}
