package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.service.sys.threadpool.MultiThreadDemo;
import com.rpm.demo.spring.service.sys.threadpool.MultiThreadProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by renpiming on 2017/11/1.
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@EnableScheduling
//指明配置文件所在
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ThreadpoolTest {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private MultiThreadProcessService multiThreadProcessService;

    @Test
    public void test() {

        int n = 20;
        for (int i = 0; i < n; i++) {
            taskExecutor.execute(new MultiThreadDemo(multiThreadProcessService));
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
