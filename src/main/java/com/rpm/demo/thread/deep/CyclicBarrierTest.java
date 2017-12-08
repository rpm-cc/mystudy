package com.rpm.demo.thread.deep;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * Created by renpiming on 2017/12/5.
 */
public class CyclicBarrierTest {


    public static void barrier1() {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }

    public static void barrier2() {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, () ->
                System.out.println("当前线程" + Thread.currentThread().getName()));
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }


    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
                //加入等待时间方式的await。所有线程在如果在超时后还没有执行完。没有执行完的辉结束，然后其他线程继续执行
                //cyclicBarrier.await(5000, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

    public static void main(String[] args) {
        // barrier1();
        barrier2();
    }
}
