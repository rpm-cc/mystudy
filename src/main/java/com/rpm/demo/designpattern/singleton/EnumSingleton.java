package com.rpm.demo.designpattern.singleton;

/**
 * Created by renpiming on 2017/12/4.
 */
public enum EnumSingleton {

    instance;


    public  void printInstance(){
        System.out.println(EnumSingleton.instance);
    }

    public void print(){

       System.out.println("print");
    }

}
