package com.rpm.demo.designpattern.factory;

/**
 * Created by renpiming on 2017/12/2.
 */
public class VehicleFactory {



    //普通工厂模式(静态工厂)
    public static Vehicle getVehicle(String type){

        if ("car".equals(type)){
            return new Car();
        }
        if ("truck".equals(type)){
            return  new Truck();
        }
        return null;
    }
    //多工厂模式
    public static Vehicle getCar(){
        return  new Car();
    }
    public static Vehicle getTruck(){
        return  new Truck();
    }



}
