package com.rpm.test;

import com.rpm.demo.spring.learn.annotations.Zoo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by gc-rise on 2017/8/9.
 */
//首先指定Junit的Runner
@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件所在
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class Test1 {
    @Autowired Zoo zoo;

    @Test
    public void test(){
        System.out.println( zoo.toString());

    }
}
