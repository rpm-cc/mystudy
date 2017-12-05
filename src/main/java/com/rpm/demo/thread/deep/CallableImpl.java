package com.rpm.demo.thread.deep;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by renpiming on 2017/12/5.
 */
public class CallableImpl implements Callable <String>{
    @Override
    public String call() throws Exception {


        return "the callable result";
    }

    public static void main(String[] args) {
        FutureTask<String> future = new FutureTask<>(new CallableImpl());
        Thread t = new Thread(future);
        t.start();


        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
