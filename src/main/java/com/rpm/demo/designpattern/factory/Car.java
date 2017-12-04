package com.rpm.demo.designpattern.factory;

/**
 * Created by renpiming on 2017/12/2.
 */
public class Car implements Vehicle {
    @Override
    public int getWheel() {
        return 4;
    }

    @Override
    public int getDoor() {
        return 4;
    }

    @Override
    public int getSpeed() {
        return 260;
    }

    @Override
    public void createVehicle() {
        System.out.println("now we create a car ");
    }
}
