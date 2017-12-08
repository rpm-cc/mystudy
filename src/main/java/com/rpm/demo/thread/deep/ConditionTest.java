package com.rpm.demo.thread.deep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by renpiming on 2017/12/5.
 * 首先count==0。这时线程两个线程进行启动；
 * 无论读线程先启动还是写线程先启动。都要看count的值来判断线程是否运行。
 * 如果写线程中的count==100，那么写线程会暂停写入。等待 notFull.signal();唤醒；
 * 如果读线程中的count=0 ，那么读线程暂停读取。等待   notEmpty.signal();唤醒；
 * 如果0<count<100 不会出现await线程。两个线程同时进行。此时signal方法会调用，
 * 也不会起什么作用了。因为本身两个线程都是清醒的。
 *
 */
public class ConditionTest {


    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] items = new Object[10];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            System.out.println("写线程" + count);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            System.out.println("读线程" + count);
            return x;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                try {
                    conditionTest.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    conditionTest.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
