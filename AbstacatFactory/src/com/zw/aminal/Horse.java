package com.zw.aminal;

import java.awt.* ;

import javax.swing.* ;

public class Horse implements Animal {
	JScrollPane sp ;
	JFrame jf = new JFrame("抽象工厂测试");
	public Horse() {
		Container c = jf.getContentPane();
		JPanel jp = new JPanel() ;
		jp.setLayout(new GridLayout(1,1));
		jp.setBorder(BorderFactory.createTitledBorder("动物: 马"));
		sp = new JScrollPane(jp);
		c.add(sp,BorderLayout.CENTER) ;
		JLabel jl = new JLabel(new ImageIcon("src/A_Horse.jpg")) ;
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
