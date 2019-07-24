package com.zw.director;

public class ConcreteDecortaor extends Dectorator{

	@Override
	public void buildWall() {
		product.setWall("w1");
		
	}

	@Override
	public void buildTV() {
		product.setSofa("s1");
		
	}

	@Override
	public void buildSofa() {
		product.setTV("t1");
		
	}

}
