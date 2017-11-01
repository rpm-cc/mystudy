package com.rpm.demo.spring.service.sys.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MultiThreadProcessService {

    public static final Logger logger = LoggerFactory.getLogger(MultiThreadProcessService.class);
    
    /**
     * 默认处理流程耗时1000ms
     */
    public void processSomething() {
        System.out.println("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MultiThreadProcessService-processSomething" + Thread.currentThread() + "......end");
    }
}