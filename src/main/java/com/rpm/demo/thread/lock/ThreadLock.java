package com.rpm.demo.thread.lock;


/**
 * Created by renpiming on 2017/11/30.
 */
public class ThreadLock {


    public void unlock(Worker worker) {

        Thread thread1 = new Thread(new UnLockRunnable(worker, "王刚", 50, 100000), "thread-1");
        Thread thread2 = new Thread(new UnLockRunnable(worker, "程序猿", 23, 130000), "thread-2");


        thread1.start();
        thread2.start();


    }

    public void locked(Worker worker) {
        Thread thread1 = new Thread(new LockedRunnable(worker, "王刚", 50, 100000), "thread-1");
        Thread thread2 = new Thread(new LockedRunnable(worker, "程序猿", 23, 130000), "thread-2");


        thread1.start();
        thread2.start();
    }

    public void deadLock() {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        worker1.setName("王刚");
        worker2.setName("程序猿");
        Thread thread1 = new Thread(new DeadLock(worker1, worker2), "thread-1");
        Thread thread2 = new Thread(new DeadLock(worker2, worker1), "thread-2");

        thread1.start();
        thread2.start();


    }

    public void threadLocal(Worker worker) {

        Thread thread1 = new Thread(new ThreadLocalDemo("王刚", 50, 100000), "thread-1");
        Thread thread2 = new Thread(new ThreadLocalDemo("程序猿", 23, 130000), "thread-2");


        thread1.start();
        thread2.start();

    }


    public static void main(String[] args) {
        Worker worker = new Worker();

        ThreadLock lock = new ThreadLock();
        //lock.unlock(worker);
        //lock.locked(worker);
        lock.deadLock();
//        for (int i = 0; i < 100; i++) {
//            lock.threadLocal(worker);
//        }

    }
}
