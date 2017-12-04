package com.rpm.demo.nosql.redis;

import com.rpm.demo.spring.beans.User;
import com.rpm.demo.spring.service.redis.impl.RedisServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by renpiming on 2017/12/1.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisOprationTest {

    @Autowired
    RedisServiceimpl redisService;

    @Test
    public  void test(){
        User user = new User();
        user.setId(10);
        user.setName("猴子");
        redisService.add(user);
        User user1 = redisService.get(user.getId()+"");
        System.out.println(user1);

    }
}