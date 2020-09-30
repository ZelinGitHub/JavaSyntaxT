package com.company.java.designmode.simplefactory;

public class HouseFactoryX {
    public static House newHouse(String pClassName){
        House house=null;
        try {
            house=(House)Class.forName(pClassName).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException pE) {
            pE.printStackTrace();
        }
        return house;
    }
}
