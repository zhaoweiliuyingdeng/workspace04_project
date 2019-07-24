package com.zw.Test;

import com.zw.aminal.Animal;
import com.zw.farm.Farm;
import com.zw.plant.Plant;

public class TestDemo {
	public static void main(String[] args) {
        try
        {          
            Farm f;
            Animal a;
            Plant p;
            f=(Farm) ReadXML.getObject();
            a=f.newAnimal();
            p=f.newPlant();
            a.show();
            p.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
	}

}
