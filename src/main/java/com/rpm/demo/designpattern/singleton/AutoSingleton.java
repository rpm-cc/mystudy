package com.rpm.demo.designpattern.singleton;

/**
 * Created by renpiming on 2017/12/19.
 */
public class AutoSingleton {
    private static AutoSingleton ourInstance = new AutoSingleton();

    public static AutoSingleton getInstance() {
        return ourInstance;
    }

    private AutoSingleton() {
    }
}
