package com.company.java.designmode.bridge.car;

import com.company.java.designmode.bridge.transmission.Transmission;

public class BenZCar extends AbstractCar {
    public BenZCar(Transmission pTransmission) {
        super(pTransmission);
    }

    @Override
    public void run() {
        mTransmission.gear();
        System.out.println("奔驰车发动");
    }
}
