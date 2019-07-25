package com.zw.change;

import com.zw.marrigan.Morrigan;
import com.zw.marrigan.Original;

public class Gril extends Changer {

	public Gril(Morrigan morrigan) {
		super(morrigan);
		// TODO Auto-generated constructor stub
	}
	public void setChanger() {
		((Original)super.morrigan).setImage("Morrigan2.jpg") ;
	}
	public void display() {
		setChanger() ;
		super.display();
	}

}
