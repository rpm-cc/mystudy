package com.rpm.demo.thread.deep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by renpiming on 2017/12/17.
 */
public class ExchangeDemo {


    public static void main(String[] args) {


        ExecutorService ex = Executors.newFixedThreadPool(10);
        Exchanger<List> exchanger = new Exchanger<>();
        ex.execute(new Runnable() {
            @Override
            public void run() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                try {
                    list = exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+list);
            }
        });

        ex.execute(new Runnable() {
            @Override
            public void run() {
                List<Integer> list = new ArrayList<>();
                list.add(3);
                list.add(4);
                try {
                    list = exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+list);
            }
        });


    }
}
