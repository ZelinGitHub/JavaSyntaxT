package com.company.designmode.bridge.car;

import com.company.designmode.bridge.transmission.Transmission;

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
