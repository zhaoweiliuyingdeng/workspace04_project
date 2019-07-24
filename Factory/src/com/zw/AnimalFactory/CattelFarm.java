package com.zw.AnimalFactory;

import com.zw.AnimalProdect.Animal;
import com.zw.AnimalProdect.Cattel;

public class CattelFarm implements AnimalFarm {

	@Override
	public Animal newAnmial() {
		System.out.println("小牛出生了!");
		return new Cattel();
	}

}
