package com.zw.test;

import com.zw.change.Gril;
import com.zw.change.Succubus;
import com.zw.marrigan.Morrigan;
import com.zw.marrigan.Original;

public class TestDemo {

	public static void main(String[] args) {
        Morrigan m0=new Original();
        m0.display();
        Morrigan m1=new Succubus(m0);
        m1.display();
        Morrigan m2=new Gril(m0);
        m2.display();
	}
}
