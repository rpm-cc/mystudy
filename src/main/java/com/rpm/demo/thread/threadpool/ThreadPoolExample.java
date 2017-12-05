package com.rpm.demo.thread.threadpool;

import java.util.concurrent.*;

/**
 * Created by renpiming on 2017/11/11.
 */
public class ThreadPoolExample {
    public void exampleCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0 ;i<10;i++){
            executorService.execute(new Worker1("this is exampleCachedThreadPool"));
            executorService.execute(new Worker2("this is exampleCachedThreadPool"));
        }
    }
    public void exampleFixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Object o =new Object();
        for (int i=0;i<10;i++){
            executorService.execute(new Worker3("this is exampleFixedThreadPool"));
        }

    }

    public void exampleSingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Worker1(null));

    }

    public void exampleScheduledThreadpool(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleAtFixedRate(new Worker3("fixedRate"),1,3, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(new Worker3("fixedDelay"),2,1,TimeUnit.SECONDS);
    }


    public void deep(){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for(int i = 1; i < 5; i++) {
            final int taskID = i;
            cs.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        // 可能做一些事情
        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }




    public static void main(String[] args) {
        ThreadPoolExample example = new ThreadPoolExample();
        example.exampleCachedThreadPool();
        example.exampleFixedThreadPool();
        example.exampleScheduledThreadpool();
        example.exampleSingleThreadExecutor();
    }







}
