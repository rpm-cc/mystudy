package com.rpm.demo.thread.deep;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by renpiming on 2017/12/6.
 */
public class VolatileTest {
    volatile int vo = 0;
    volatile   AtomicInteger atomic = new AtomicInteger();
    public void increase() {
        vo++;
    }

    public void atomicIncrease() {
        atomic.getAndIncrement();
    }

    public static void main(String[] args) {

        final VolatileTest volatileTest = new VolatileTest();
        for (int num = 0; num < 10; num++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.increase();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.increase();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.increase();
            }).start();

            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.atomicIncrease();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.atomicIncrease();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    volatileTest.atomicIncrease();
            }).start();
        }
        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();


        System.out.println(volatileTest.vo);
        System.out.println(volatileTest.atomic.get());
    }
}
