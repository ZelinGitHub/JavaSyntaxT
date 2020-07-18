package com.company.designmode.bridge.car;

import com.company.designmode.bridge.transmission.Transmission;

public abstract class AbstractCar {
    protected Transmission mTransmission;

    public AbstractCar(Transmission pTransmission) {
        mTransmission = pTransmission;
    }

    public abstract void run();


}
