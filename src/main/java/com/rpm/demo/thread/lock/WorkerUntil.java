package cn.rpm.learn.extend.lock;

/**
 * Created by renpiming on 2017/12/1.
 */
public class WorkerUntil {
    //ThreadLocal 的正确获取方式；
    public static final ThreadLocal<Worker> local = new ThreadLocal<>();

    public static Worker getWorker() {

        Worker worker = local.get();
        if(worker==null) {
            worker = new Worker();
            local.set(worker);
        }
        return worker;


    }
}
