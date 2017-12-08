package com.rpm.demo.thread.deep;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Created by renpiming on 2017/12/8.
 */
public class ThreadException {


    public static void main(String[] args) {
        final Integer count = 0;

       Thread t1 =  new Thread(() -> {
            synchronized (count) {

                throw new RuntimeException();
            }
        }, "exception-thread");


        Thread t2 = new Thread(() -> {
            try {
                synchronized (count) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "runnin-thread");
        t1.start();
        t2.setUncaughtExceptionHandler(new MyThreadExceptionHandler());
        t2.start();
    }


}


