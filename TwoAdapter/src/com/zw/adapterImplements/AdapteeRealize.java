package com.zw.adapterImplements;

import com.zw.adapter.TwoWayAdaptee;

public class AdapteeRealize implements TwoWayAdaptee {

	@Override
	public void specificRequest() {
		System.out.println("适配者实现");
	}

}
