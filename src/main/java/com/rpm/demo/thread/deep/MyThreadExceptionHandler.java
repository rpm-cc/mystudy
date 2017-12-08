package com.rpm.demo.thread.deep;

public class MyThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        System.out.println("we catch the Exception");


    }
}