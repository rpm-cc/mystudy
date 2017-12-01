package cn.rpm.learn.extend.lock;

/**
 * Created by renpiming on 2017/12/1.
 */
public class ThreadLocalDemo implements Runnable {


    private String name;
    private int age;
    private int pay;

    public ThreadLocalDemo(String name, int age, int pay) {
        this.name = name;
        this.age = age;
        this.pay = pay;
    }

    @Override
    public void run() {
        Worker worker = WorkerUntil.getWorker();
        for (int i = 0; i < 10; i++) {

            worker.setAge(age);
            worker.setName(name);
            worker.setPay(pay);

            if(Thread.currentThread().getName().equals("thread-1") && !worker.getName().equals("王刚")){
                System.out.println(Thread.currentThread().getName()+"==> the result is wrong");
            }else if(Thread.currentThread().getName().equals("thread-2")&&!worker.getName().equals("程序猿")){
                System.out.println(Thread.currentThread().getName()+"==> the result is wrong");
            }else {
               // System.out.println(Thread.currentThread().getName() + "==>" + worker.toString());
            }


        }
    }



}
