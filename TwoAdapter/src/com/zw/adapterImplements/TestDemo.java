package com.zw.adapterImplements;

import com.zw.adapter.TwoWayAdaptee;
import com.zw.adapter.TwoWayTarget;

public class TestDemo {

	public static void main(String[] args) {
		System.out.println("目标通过双向适配器访问适配者");
		TwoWayAdaptee adaptee = new AdapteeRealize() ;
		TwoWayTarget target = new TwoWayAdapter(adaptee) ;
		target.request();
		System.out.println("--------------------");
		System.out.println("适配者通过双向适配器访问目标");
		 target = new TargetRealize() ;
		 adaptee = new TwoWayAdapter(target) ;
		adaptee.specificRequest();
		
		
	}

}
