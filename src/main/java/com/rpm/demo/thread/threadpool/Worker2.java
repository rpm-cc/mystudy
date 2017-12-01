package com.rpm.demo.thread.threadpool;

/**
 * Created by renpiming on 2017/11/11.
 */
public class Worker2 implements Runnable{


    private String param ;
    public Worker2(String param){
        this.param = param;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is working");


    }
}
