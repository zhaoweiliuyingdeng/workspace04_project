package com.zw.adapter;

import com.zw.adaptee.OpticalMotor;

public class OpticalAdapter implements Motor {
	private OpticalMotor om ;

	public OpticalAdapter() {
		om = new OpticalMotor() ;
	}
	@Override
	public void driver() {
		om.opticalDriver();

	}

}
