package com.company.java.designmode.bridge.transmission;

public class ManualTransmission extends Transmission {
    @Override
    public void gear() {
        System.out.println("手动变速器开始工作");
    }
}
