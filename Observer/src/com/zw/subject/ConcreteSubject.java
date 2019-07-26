package com.zw.subject;

import com.zw.observer.Observer;

public class ConcreteSubject extends Subject {

	@Override
	public void notifyObserver() {
		System.out.println("具体目标发生变化");
		System.out.println("--------------------");
		for(Object obs : observer) {
			((Observer)obs).response();
		}
	}

}
