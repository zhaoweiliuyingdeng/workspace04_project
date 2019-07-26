package com.zw.imp;

import java.util.ArrayList;

import com.zw.aritile.Articles;

public class Bags implements Articles {
	private String name ;
	private ArrayList<Articles> bags = new ArrayList<Articles>() ;
	public Bags(String name ) {
		this.name = name ;
	}
	public void add(Articles c) {
		bags.add(c) ;
	}
	public void remove(Articles c) {
		bags.remove(c) ;
	}
	public Articles getChild(int i) {
		return bags.get(i) ;
	}

	@Override
	public float calculation() {
		float f = 0 ;
		for(Object obj : bags) {
			f += ((Articles)obj).calculation() ;
		}
		return f;
	}

	@Override
	public void show() {
		for(Object obj : bags) {
			((Articles)obj).show();
		}

	}

}
