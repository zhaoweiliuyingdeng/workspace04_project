package com.zw.Prototype02;

public class DemoTest {
	public static void main(String[] args) {
        PrototypeManager pm=new PrototypeManager();    
        Shape obj1=(Circle)pm.getShape("Circle");
        obj1.countArea();          
        Shape obj2=(Shape)pm.getShape("Square");
        obj2.countArea();     
	}

}
