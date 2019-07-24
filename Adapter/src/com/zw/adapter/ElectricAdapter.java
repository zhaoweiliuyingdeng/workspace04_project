package com.zw.adapter;

import com.zw.adaptee.ElectricMotor;

public class ElectricAdapter implements Motor {
	private ElectricMotor em ;
	public ElectricAdapter() {
		em = new ElectricMotor() ;
	}
	@Override
	public void driver() {
		em.electricDreiver();

	}

}
