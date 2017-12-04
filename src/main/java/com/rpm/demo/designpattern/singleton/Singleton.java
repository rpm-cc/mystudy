package com.rpm.demo.designpattern.singleton;

/**
 * Created by renpiming on 2017/12/2.
 */
public class Singleton {

    //private static Singleton singleton;
    private Singleton(){};

//    public Singleton getInstance(){
//
//        if(singleton==null){
//            singleton = new Singleton();
//        }
//
//        return singleton;
//    }



    static class  SingletonFactory{

        private static Singleton instance = new Singleton();

    }

    public static Singleton getInstance(){
        return  SingletonFactory.instance;
    }

}
