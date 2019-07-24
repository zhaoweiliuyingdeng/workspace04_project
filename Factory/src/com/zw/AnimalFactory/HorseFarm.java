package com.zw.AnimalFactory;

import com.zw.AnimalProdect.Animal;
import com.zw.AnimalProdect.Horse;

public class HorseFarm implements AnimalFarm {

	@Override
	public Animal newAnmial() {
		System.out.println("新马出生了!");
		return new Horse();
	}

}
