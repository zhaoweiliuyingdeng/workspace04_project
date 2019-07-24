package com.zw.director;

public class ConcreteDecoator2 extends Dectorator {

	@Override
	public void buildWall() {
		product.setWall("w2");

	}

	@Override
	public void buildTV() {
		product.setSofa("s2");

	}

	@Override
	public void buildSofa() {
		product.setTV("t2");

	}

}
