package com.zw.change;

import com.zw.marrigan.Morrigan;

public class Changer implements Morrigan {
	protected Morrigan morrigan ;
	public Changer(Morrigan morrigan) {
		this.morrigan = morrigan ;
	}

	@Override
	public void display() {
		morrigan.display();

	}

}
