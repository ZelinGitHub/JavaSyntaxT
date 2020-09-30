package com.company.java.designmode.bridge.car;

import com.company.java.designmode.bridge.transmission.Transmission;

public abstract class AbstractCar {
    protected Transmission mTransmission;

    public AbstractCar(Transmission pTransmission) {
        mTransmission = pTransmission;
    }

    public abstract void run();


}
