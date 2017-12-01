package com.rpm.demo.thread.threadpool;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;

/**
 * Created by renpiming on 2017/11/11.
 */
public class Worker1 implements Runnable{


    private Object param ;
    public Worker1(Object param){
        this.param = param;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is working");


    }
}
