package com.company.designmode.bridge;

import com.company.designmode.bridge.car.AbstractCar;
import com.company.designmode.bridge.car.BMWCar;
import com.company.designmode.bridge.car.BenZCar;
import com.company.designmode.bridge.car.LandRoverCar;
import com.company.designmode.bridge.transmission.AutoTransmission;
import com.company.designmode.bridge.transmission.ManualTransmission;
import com.company.designmode.bridge.transmission.Transmission;

public class BridgeTest {
    public static void test() {
        Transmission manualTransmission = new ManualTransmission();
        Transmission autoTransmission = new AutoTransmission();

        AbstractCar manualBMWCar = new BMWCar(manualTransmission);
        AbstractCar autoBMWCar = new BMWCar(autoTransmission);
        AbstractCar manualBenZCar=new BenZCar(manualTransmission);
        AbstractCar autoBenZCar=new BenZCar(autoTransmission);
        AbstractCar manualLandRoverCar=new LandRoverCar(manualTransmission);
        AbstractCar autoLandRoverCar=new LandRoverCar(autoTransmission);

        manualBMWCar.run();
        autoBMWCar.run();
        manualBenZCar.run();
        autoBenZCar.run();
        manualLandRoverCar.run();
        autoLandRoverCar.run();


    }
}
