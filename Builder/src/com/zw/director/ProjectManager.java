package com.zw.director;

import com.zw.product.Parlour;

public class ProjectManager {
	private Dectorator builder ;
	public ProjectManager(Dectorator builder) {
		this.builder = builder ;
	}
	public Parlour decortaor() {
		builder.buildSofa();
		builder.buildTV();
		builder.buildWall();
		return builder.getresult() ;
	}
	

}
