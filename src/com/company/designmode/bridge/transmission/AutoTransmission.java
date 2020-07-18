package com.company.designmode.bridge.transmission;

public class AutoTransmission extends Transmission {
    @Override
    public void gear() {
        System.out.println("自动变速器开始工作");
    }
}
