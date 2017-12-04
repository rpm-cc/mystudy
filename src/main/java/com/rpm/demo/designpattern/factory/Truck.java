package com.rpm.demo.designpattern.factory;

/**
 * Created by renpiming on 2017/12/2.
 */
public class Truck implements Vehicle {
    @Override
    public int getWheel() {
        return 8;
    }

    @Override
    public int getDoor() {
        return 2;
    }

    @Override
    public int getSpeed() {
        return 100;
    }

    @Override
    public void createVehicle() {
        System.out.println("now we create a truck ");
    }
}
