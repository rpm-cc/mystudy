package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.UserMenue;
import com.rpm.demo.spring.commons.JsonUtil;
import com.rpm.demo.spring.service.sys.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by gc-rise on 2017/8/9.
 */
//首先指定Junit的Runner
@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件所在
@ContextConfiguration(locations="classpath:applicationContext.xml")
//指定事务管理器
@Transactional(transactionManager="transactionManager")
//继承AbstractTransactionalJUnit4SpringContextTests来获取Spring上下文环境来获取Bean
public class DemoControllerTest {


    @Autowired
    SystemService sysService;
    @Test
    public void wellcome() throws Exception {
        UserMenue userMenue  = sysService.getMenues(1);
        System.out.println(JsonUtil.toJson(userMenue));
    }

    @Test
    public void grid() throws Exception {

    }

    @Test
    public void jqgrid() throws Exception {

    }

    @Test
    public void tables() throws Exception {

    }

    @Test
    public void jqueryui() throws Exception {

    }

    @Test
    public void treeview() throws Exception {

    }

}