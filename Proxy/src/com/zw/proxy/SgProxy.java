package com.zw.proxy;

public class SgProxy implements Specialty {
	private WySpecialty wy = new WySpecialty() ;

	@Override
	public void display() {
        preRequest();
        wy.display();
        postRequest();

	}
    public void preRequest()
    {
          System.out.println("韶关代理婺源特产开始。");
    }
    public void postRequest()
    {
          System.out.println("韶关代理婺源特产结束。");
    }

}
