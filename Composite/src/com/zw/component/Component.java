package com.zw.component;

public interface Component {
	public void add(Component c) ;
	public void remove(Component c) ;
	public Component gitChild(int i) ;
	public void operation() ;

}
