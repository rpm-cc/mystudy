package cn.rpm.learn.extend.threadpool;

/**
 * Created by renpiming on 2017/11/11.
 */
public class Worker3 implements Runnable{


    private String param ;
    public Worker3(String param){
        this.param = param;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is working"+param);


    }
}
