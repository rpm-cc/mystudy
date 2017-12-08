package com.rpm.demo.thread.lock;

import com.rpm.demo.thread.deep.MyThreadExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by renpiming on 2017/12/2.
 */
public class WaitAnNotify {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Thread t1 = new Thread(new JiShu(list), "jishu");
        Thread t2 = new Thread(new OuShu(list), "oushu");
        Thread t3 = new Thread(new NumDaemon(), "daemon");
        t3.setDaemon(true);
        t1.start();
        t1.setUncaughtExceptionHandler(new MyThreadExceptionHandler());
        t2.start();
        t3.start();
        try {
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}

class JiShu implements Runnable {
    List<Integer> list;

    public JiShu(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            int count = 1;

            for (int i : list) {
                if (count % 100 == 0) {
                    try {
                        System.out.println("奇数线程进入等待");
                        count = 1;
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 1) {
                    System.out.println("输出奇数==>" + i);
                    count++;
                    if (count % 100 == 0) {
                        System.out.println("唤醒偶数线程");
                        list.notify();
                    }
                }

            }
            System.out.println("奇数线程执行完毕，即将退出！");
            list.notify();

        }
    }
}

class OuShu implements Runnable {
    List<Integer> list;

    public OuShu(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            int count = 1;
            for (int i = 0; i < list.size(); i++) {
                if (count % 100 == 0) {
                    try {
                        System.out.println("偶数线程进入等待");
                        count = 1;
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    System.out.println("输出偶数==>" + list.get(i));
                    count++;
                    if (count % 100 == 0) {
                        System.out.println("唤醒奇数线程");
                        list.notify();
                    }
                }
            }
            System.out.println("偶数线程只从完毕，即将退出！");
            list.notify();
        }
    }
}

class NumDaemon implements Runnable {
    //用作守护线程，大体作用统计线程的执行时间。
    @Override
    public void run() {
        int sss = 0;
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sss += 10;
            // System.out.println(sss+"ms was pass！！");
        }


    }
}