package com.rpm.demo.thread.lock;

/**
 * Created by renpiming on 2017/11/30.
 */
public class Worker {

    public String name ;
    public int age  ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int pay;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pay=" + pay +
                '}';
    }
}
