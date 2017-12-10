package com.rpm.demo.thread.blockqueue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by renpiming on 2017/12/9.
 */
public class CurrentMap {


    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new LinkedHashMap<>();
        Map<String, Integer> map3 = new ConcurrentHashMap<>();//大幅度提高写并发能力
    }
}


class MapOprition implements Runnable {

    Map<String, Integer> map;

    public MapOprition(Map<String, Integer> map) {
        this.map = map;
    }


    @Override
    public void run() {
        map.put("test", 1);
    }
}