package com.company.designmode.simplefactory;

public class HouseFactory {
    public static House newHouse(String pName) {
        House house = null;
        switch (pName) {
            case "edifice": {
                house = new EdificeHouse();
            }
            case "lodge": {
                house = new LodgeHouse();
            }
            case "tent": {
                house = new TentHouse();
            }
        }
        return house;
    }
}
