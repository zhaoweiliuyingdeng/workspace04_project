package com.zw.subject;

import com.zw.company.Company;

public class PMBRate extends Rate {

	@Override
	public void change(int number) {
		for(Company obj : companys) {
			obj.resopnse(number);
		}
	}

}
