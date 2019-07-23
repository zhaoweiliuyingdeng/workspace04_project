package com.zw.Prototype02;

import java.util.HashMap;

public class PrototypeManager {

	private HashMap<String,Shape> ht = new HashMap<String, Shape>() ;
	public PrototypeManager() {
		ht.put("Circle",new Circle()) ;
		ht.put("Square",new Square()) ;
	}
	public void addShape(String key , Shape obj) {
		ht.put(key, obj) ;
	}
	public Shape getShape(String key) {
		Shape temp = ht.get(key) ;
		return (Shape) temp.clone() ;
	}
}
