package com.zw.aminal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Cattle implements Animal {

	JScrollPane sp ;
	JFrame jf = new JFrame("抽象工厂测试");
	public Cattle() {
		Container c = jf.getContentPane();
		JPanel jp = new JPanel() ;
		jp.setLayout(new GridLayout(1,1));
		jp.setBorder(BorderFactory.createTitledBorder("动物: 牛"));
		sp = new JScrollPane(jp);
		c.add(sp,BorderLayout.CENTER) ;
		JLabel jl = new JLabel(new ImageIcon("src/A_Cattle.jpg")) ;
		jp.add(jl) ;
		jf.pack();
		jp.setVisible(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void show() {
		jf.setVisible(true);
	}

}
