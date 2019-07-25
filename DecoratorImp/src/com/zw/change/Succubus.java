package com.zw.change;

import com.zw.marrigan.Morrigan;
import com.zw.marrigan.Original;

public class Succubus extends Changer {

	public Succubus(Morrigan morrigan) {
		super(morrigan);
		
	}
	public void setChanger() {
		 ((Original) super.morrigan).setImage("Morrigan1.jpg");  
	}
	public void display() {
		setChanger() ;
		super.display();
		
	}

}
