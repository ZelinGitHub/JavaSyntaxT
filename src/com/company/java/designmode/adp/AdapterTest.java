package com.company.java.designmode.adp;


public class AdapterTest {


    public static void testAdapter2() {
        TwentyVolt twentyVolt = new TwentyVolt();
        ElectricAdapter electricAdapter = new ElectricAdapter(twentyVolt);
        chargePhone(electricAdapter);
    }

    public static void chargePhone(FiveVolt pFiveVolt) {
        System.out.println("电流：" + pFiveVolt.getLittleElectricity());
    }
}
