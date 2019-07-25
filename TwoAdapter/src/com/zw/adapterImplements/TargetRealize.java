package com.zw.adapterImplements;

import com.zw.adapter.TwoWayTarget;

public class TargetRealize implements TwoWayTarget {

	@Override
	public void request() {
		System.out.println("目标者代码被调用");

	}

}
