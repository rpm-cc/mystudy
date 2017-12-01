package com.rpm.demo.thread.lock;

/**
 * Created by renpiming on 2017/11/30.
 */
public class UnLockRunnable implements  Runnable {

    private  Worker worker;
    private String name ;
    private int age;
    private int pay;
    public UnLockRunnable(Worker worker,String name ,int age ,int pay ) {
        this.worker = worker;
        this.name = name;
        this.age = age;
        this.pay = pay;
    }

    @Override
    public void run() {

        for (int i = 0 ;i<10;i++){
            worker.setAge(age);
            worker.setName(name);
            worker.setPay(pay);
            System.out.println(Thread.currentThread().getName()+"==>"+worker.toString());
        }



    }
}
