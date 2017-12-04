package com.rpm.demo.designpattern.factory;

/**
 * Created by renpiming on 2017/12/2.
 */
public class TruckFactory extends VehicleProvider {
    @Override
    public Vehicle getVehicle() {
        return new Truck();
    }
}
