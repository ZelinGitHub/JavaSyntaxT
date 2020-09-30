package com.company.java.designmode.bridge.car;

import com.company.java.designmode.bridge.transmission.Transmission;

public class LandRoverCar extends AbstractCar {
    public LandRoverCar(Transmission pTransmission) {
        super(pTransmission);
    }

    @Override
    public void run() {
        mTransmission.gear();
        System.out.println("路虎车发动");
    }
}
