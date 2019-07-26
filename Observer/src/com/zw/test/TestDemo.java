package com.zw.test;

import com.zw.observer.ConcreteObserver1;
import com.zw.observer.ConcreteObserver2;
import com.zw.observer.Observer;
import com.zw.subject.ConcreteSubject;
import com.zw.subject.Subject;

public class TestDemo {
	public static void main(String[] args) {
		Subject sub = new ConcreteSubject() ;
		Observer obs1 = new ConcreteObserver1() ;
		Observer obs2 = new ConcreteObserver2() ;
		sub.add(obs1);
		sub.add(obs2);
		sub.notifyObserver();
		
	}

}
