package com.zw.AnimalProdect;

import java.awt.* ;

import javax.swing.* ;
public class Horse implements Animal {

    JScrollPane sp;
    JFrame jf=new JFrame("工厂方法模式测试");
    public Horse() {
    	Container c = jf.getContentPane() ;
    	JPanel jp = new JPanel() ;
    	jp.setLayout(new GridLayout(1,1));
    	jp.setBorder(BorderFactory.createTitledBorder("动物: 马"));
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
