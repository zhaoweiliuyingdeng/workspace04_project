package com.zw.Prototype;

import java.awt.*;

import javax.swing.*;

class SunWuKong extends JPanel implements Cloneable{
	private static final Long serialVersionUID = 5543049531872119328L ; 
	public SunWuKong(){
		JLabel l1 = new JLabel(new ImageIcon("src/Wukong.jpg")) ;
		this.add(l1) ;
	}
	public Object clone() {
		SunWuKong sw = null ;
		try {
			sw = (SunWuKong)super.clone() ;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("复制悟空失败！");
		}
		return sw ;
	}
	
}
public class PrototypeWukong {
	public static void main(String[] args) {
		JFrame jf = new JFrame("悟空测试原型模式");
		jf.setLayout(new GridLayout(1,2));
		Container cp = jf.getContentPane();
		SunWuKong obj1 = new SunWuKong() ;
		cp.add(obj1);
		SunWuKong obj2 = new SunWuKong() ;
		cp.add(obj2) ;
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
