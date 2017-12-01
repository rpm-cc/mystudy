package com.rpm.demo.thread.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by renpiming on 2017/12/1.
 */
public class ReflectDemo {


    public void oprationString() throws Exception {

        String s = "";
        Class clazz = Class.forName("java.lang.String");
        Constructor[] con = clazz.getConstructors();
        Field[] fields = clazz.getFields();
        Method[] methods = clazz.getMethods();




    }


    public static void main(String[] args) {

        ReflectDemo demo = new ReflectDemo();


        try {
            demo.oprationString();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
