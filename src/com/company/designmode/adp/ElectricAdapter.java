package com.company.designmode.adp;

public class ElectricAdapter implements FiveVolt {
    private TwentyVolt mTwentyVolt;

    public ElectricAdapter(TwentyVolt pTwentyVolt) {
        mTwentyVolt = pTwentyVolt;
    }

    public int getLittleElectricity() {
        return mTwentyVolt.getElectricity() - 15;
    }
}
