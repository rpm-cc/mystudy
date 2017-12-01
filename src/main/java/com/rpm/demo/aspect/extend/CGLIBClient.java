package com.rpm.demo.aspect.extend;

import org.springframework.cglib.proxy.Enhancer;

import java.util.Date;

/**
 * Created by renpiming on 2017/11/10.
 */
public class CGLIBClient {

    public static void main(String[] args) {
        // 创建要被代理的类。
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(CGLIBFindJob.class);
        enhancer.setCallback(new CGLIBInterceptor());
        CGLIBFindJob findJob=(CGLIBFindJob)enhancer.create();

         findJob.sendResume("腾讯集团");
         findJob.goToInterview(new Date());
         findJob.result();
    }
}
