package com.company.designmode.adp2;

import com.company.designmode.adp.VoltAdapter;

public class AdapterTest {

    public static void testAdapter1() {
        VoltAdapter voltAdapter = new VoltAdapter();
        System.out.println("输出电压：" + voltAdapter.getVolt5());

    }

    public static void testAdapter2() {
        TwentyVolt twentyVolt = new TwentyVolt();
        ElectricAdapter electricAdapter = new ElectricAdapter(twentyVolt);
        System.out.println("输出电压：" + electricAdapter.getVoltFive());
    }

}
