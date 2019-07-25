package com.zw.adapterImplements;

import com.zw.adapter.TwoWayAdaptee;
import com.zw.adapter.TwoWayTarget;

public class TwoWayAdapter implements TwoWayAdaptee, TwoWayTarget {
	private TwoWayAdaptee adaptee ;
	private TwoWayTarget target ;
	public  TwoWayAdapter(TwoWayAdaptee adaptee) {
		this.adaptee = adaptee ;
	}
	public  TwoWayAdapter(TwoWayTarget target) {
		this.target = target ;
	}

	@Override
	public void request() {
		adaptee.specificRequest();

	}

	@Override
	public void specificRequest() {
		target.request();
	}

}
