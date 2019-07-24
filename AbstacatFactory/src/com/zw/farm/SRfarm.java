package com.zw.farm;

import com.zw.aminal.Animal;
import com.zw.aminal.Horse;
import com.zw.plant.Fruitage;
import com.zw.plant.Plant;

public class SRfarm implements Farm {

	@Override
	public Animal newAnimal() {
		System.out.println("新马出生！");
		return new Horse();
	}

	@Override
	public Plant newPlant() {
		System.out.println("新水果长成！");
		return new Fruitage();
	}

}
