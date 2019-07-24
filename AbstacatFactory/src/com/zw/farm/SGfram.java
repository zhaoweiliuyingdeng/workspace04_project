package com.zw.farm;

import com.zw.aminal.Animal;
import com.zw.aminal.Cattle;
import com.zw.plant.Plant;
import com.zw.plant.Vegetable;

public class SGfram implements Farm {

	@Override
	public Animal newAnimal() {
		System.out.println("新牛出生！");
		return new Cattle();
	}

	@Override
	public Plant newPlant() {
		System.out.println("植物长成");
		return new Vegetable();
	}

}
