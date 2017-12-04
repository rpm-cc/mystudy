package com.rpm.demo.designpattern.singleton;

/**
 * Created by renpiming on 2017/12/2.
 */
public class TestSingleton {


    public static void main(String[] args) {


        Singleton singleton = Singleton.getInstance();

        Singleton singleton1 = Singleton.getInstance();


        System.out.println(singleton+"--"+singleton1);



        EnumSingleton.instance.printInstance();
        EnumSingleton.instance.print();
    }
}
