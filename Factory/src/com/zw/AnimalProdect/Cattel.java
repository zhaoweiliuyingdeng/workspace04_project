package com.zw.AnimalProdect;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Cattel implements Animal {

	JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Cattel() {
    	Container c = jf.getContentPane() ;
    	JPanel jp = new JPanel() ;
    	jp.setLayout(new GridLayout(1,1));
    	jp.setBorder(BorderFactory.createTitledBorder("动物: 牛"));
    	sp = new JScrollPane(jp) ;
    	c.add(sp, BorderLayout.CENTER) ;
        JLabel l1=new JLabel(new ImageIcon("src/A_Horse.jpg"));
        jp.add(l1);       
        jf.pack();       
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //用户点击窗口关闭 
    }
	@Override
	public void show() {
		jf.setVisible(true);
	}
}
