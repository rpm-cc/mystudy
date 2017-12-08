package com.rpm.demo.thread.blockqueue;

import java.util.concurrent.*;

/**
 * Created by renpiming on 2017/12/8.
 */
public class QueueTest {



    public static void main(String[] args) {

        final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);

        final LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

        final PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();

        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        Thread t1 = new Thread(new MyProducer(synchronousQueue));
        t1.start();
        Thread t2  = new Thread(new MyConsumer(synchronousQueue));
        t2.start();


    }


}


class MyProducer implements Runnable {
    BlockingQueue<String> queue;

    public MyProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        while (true) {
            try {
                queue.put("生产的产品");
                System.out.println("生产者生产产品");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyConsumer implements Runnable {
    BlockingQueue<String> queue;

    public MyConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String res = null;
            try {
                res = queue.take();
                System.out.println("消费者取出" + res);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}