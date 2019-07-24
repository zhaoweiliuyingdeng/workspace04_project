package com.zw.proxy;

import java.awt.GridLayout;

import javax.swing.*;

public class WySpecialty extends JFrame implements Specialty {

    private static final long serialVersionUID=1L;
    public WySpecialty()
    {
        super("韶关代理婺源特产测试");
        this.setLayout(new GridLayout(1,1));
        JLabel l1=new JLabel(new ImageIcon("src/P_Vegetables.jpg"));
        this.add(l1);   
        this.pack();       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }
    public void display()
    {
        this.setVisible(true);
    }

}
