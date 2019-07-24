package com.zw.Test;

import com.zw.AnimalFactory.AnimalFarm;
import com.zw.AnimalProdect.Animal;
import com.zw.FactoryMethod.ReadXML2;

public class DemoTest01 {

    public static void main(String[] args)
    {
        try
        {
            Animal a;
            AnimalFarm af;
            af=(AnimalFarm) ReadXML2.getObject();
            a=af.newAnmial();
            a.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
