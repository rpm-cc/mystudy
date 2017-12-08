package com.rpm.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by renpiming on 2017/11/30.
 */
public class DeadLock implements Runnable {
    Worker worker1;
    Worker worker2;


    public DeadLock(Worker worker1, Worker worker2) {
        this.worker1 = worker1;
        this.worker2 = worker2;
    }

    @Override
    public void run() {

        synchronized (worker1) {
            try {
                //使用休眠的方式模拟产生死锁的情景
                Thread.sleep(10);
                worker1.wait();
                System.out.println(Thread.currentThread().getName() + " is locked the object   " + worker1.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (worker2) {
                worker2.setName(worker1.getName());
                System.out.println(Thread.currentThread().getName() + "==> worker1" + worker1.toString() + "  worker2" + worker2.toString());
            }
        }

    }


}
