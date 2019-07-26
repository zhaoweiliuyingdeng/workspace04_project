package com.zw.subject;

import java.util.ArrayList;
import java.util.List;

import com.zw.observer.Observer;

public abstract class Subject {
	protected List<Observer> observer = new ArrayList<Observer>() ;
	//增加观察者方法
	public void add(Observer obs) {
		observer.add(obs) ;
	}
	//删除观察者方法
	public void delete(Observer obs) {
		observer.remove(obs) ;
	}
	//通知观察者方法
	public abstract void notifyObserver() ;

}
