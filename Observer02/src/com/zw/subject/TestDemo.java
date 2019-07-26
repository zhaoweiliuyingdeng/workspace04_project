package com.zw.subject;

import com.zw.company.Company;
import com.zw.company.ExportCompany;
import com.zw.company.ImportCompany;

public class TestDemo {

	public static void main(String[] args) {
        Rate rate=new PMBRate();         
        Company watcher1=new ImportCompany(); 
        Company watcher2=new ExportCompany();           
        rate.add(watcher1); 
        rate.add(watcher2);           
        rate.change(10);
        rate.change(-9);

	}

}
