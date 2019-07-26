package com.zw.test;

import com.zw.abstraction.Abstraction;
import com.zw.abstraction.RefinedAbstraction;
import com.zw.bridge.ConcreteImplenentor;
import com.zw.bridge.Implementor;

public class TestDemo {

	public static void main(String[] args) {
		Implementor imple = new ConcreteImplenentor() ;
		Abstraction abs = new RefinedAbstraction(imple) ;
		abs.Operation();

	}

}
