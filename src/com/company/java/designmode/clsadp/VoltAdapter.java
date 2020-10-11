package com.company.java.designmode.clsadp;

public class VoltAdapter extends Volt220 implements SixVolt {
    @Override
    public int getVoltSix() {
        return 6;
    }
}
