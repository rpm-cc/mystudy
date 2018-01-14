package com.rpm.demo.function;

import org.apache.kafka.common.protocol.types.Field;

/**
 * Created by renpiming on 2017/12/14.
 */
public class Child extends Father {


    public String str = "child string";

    public Child (){
        System.out.println("child contructor");
    }


    public static void main(String[] args) {
        Child child = new Child();
        child.toPrint();
    }


}
