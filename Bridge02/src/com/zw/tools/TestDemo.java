package com.zw.tools;

import java.awt.* ;

import javax.swing.*;

import com.zw.abstraction.Bags;
import com.zw.color.Color;

public class TestDemo {

    public static void main(String[] args)
    {
        Color color;
        Bags bag;
        color=(Color)ReadXML.getObject("color");
        bag=(Bags)ReadXML.getObject("bag");
        bag.setColor(color);
        String name=bag.getName();
        show(name);
    }
    public static void show(String name)
    {
        JFrame jf=new JFrame("桥接模式测试");
        Container contentPane=jf.getContentPane();
        JPanel p=new JPanel();   
        JLabel l=new JLabel(new ImageIcon("src/bridge/"+name+".jpg"));
        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();  
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
