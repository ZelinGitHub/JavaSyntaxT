package com.company.java.designmode.bridge.car;

import com.company.java.designmode.bridge.transmission.Transmission;

public class BMWCar extends AbstractCar {
    public BMWCar(Transmission pTransmission) {
        super(pTransmission);
    }

    @Override
    public void run() {
        mTransmission.gear();
        System.out.println("宝马车发动");
    }
}
