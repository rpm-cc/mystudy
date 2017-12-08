package com.rpm.demo.thread.deep;

import java.util.concurrent.Semaphore;

/**
 * Created by renpiming on 2017/12/5.
 * Semaphore 主要处理的是最大线程数量的问题。当一个处理使用多线程方式进行处理各自的任务时。
 * 在同一时间段内允许的最大并发值
 *
 *
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
