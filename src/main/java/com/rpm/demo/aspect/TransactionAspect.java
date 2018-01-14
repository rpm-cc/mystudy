package com.rpm.demo.aspect;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by renpiming on 2017/12/18.
 */
@Aspect
@Component
public class TransactionAspect {

    @AdviceName("txAdvice")
    @Pointcut("execution(* com.rpm.demo.spring.service..*(..))")
    public void insert() {
    }

}
