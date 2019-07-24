package com.zw.director;

import com.zw.product.Parlour;

public abstract class Dectorator {
	protected Parlour product = new Parlour();
	public abstract void buildWall() ;
	public abstract void buildTV() ;
	public abstract void buildSofa() ;
	public  Parlour getresult() {
		return product ;
	}


}
