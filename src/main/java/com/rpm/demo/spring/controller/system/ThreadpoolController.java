package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.service.sys.threadpool.MultiThreadDemo;
import com.rpm.demo.spring.service.sys.threadpool.MultiThreadProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by renpiming on 2017/11/1.
 */
@Controller
@RequestMapping("thread")
public class ThreadpoolController {
    @Autowired
    ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    MultiThreadProcessService multiThreadProcessService;
    @RequestMapping("pool")
    public @ResponseBody
    OutBody pool (HttpServletRequest request , HttpServletResponse response){
            int n = 20;
            for (int i = 0; i < n; i++) {
                taskExecutor.execute(new MultiThreadDemo(multiThreadProcessService));
            }
            return  new OutBody();
    }


}
