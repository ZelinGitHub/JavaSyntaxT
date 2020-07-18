package com.company.designmode.simplefactory;

public class SimpleFactoryTest {
    public static void test() {
        House house = HouseFactory.newHouse("lodge");
        house.dwell();

        House house2=HouseFactoryX.newHouse("com.company.designmode.simplefactory.EdificeHouse");

    }
}
