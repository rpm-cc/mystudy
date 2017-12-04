package com.rpm.demo.designpattern.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by renpiming on 2017/12/2.
 * 用于抽象工厂的建设
 */
public abstract class VehicleProvider {

    public  void descr(){
        System.out.println("this is a abstract class ");
    }

    abstract  Vehicle getVehicle();

}
