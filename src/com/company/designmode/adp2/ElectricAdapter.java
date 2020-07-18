package com.company.designmode.adp2;

public class ElectricAdapter implements FiveVolt {
    private TwentyVolt mTwentyVolt;

    public ElectricAdapter(TwentyVolt pTwentyVolt){
        mTwentyVolt=pTwentyVolt;
    }

    public int getTwentyVolt(){
        return mTwentyVolt.getVoltTwenty();
    }

    @Override
    public int getVoltFive() {
        return 5;
    }
}
