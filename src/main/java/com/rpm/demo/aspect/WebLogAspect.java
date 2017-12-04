package com.rpm.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by renpiming on 2017/11/10.
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    ThreadLocal<Long> timeConsume = new ThreadLocal<>();

    @Pointcut("execution(public * com.rpm.demo..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        timeConsume.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - timeConsume.get()) + " ms");

    }


   /**
    <aop:config>
            <aop:aspect id="logMethod" ref="webLogAspect">
                <aop:pointcut id="weblog" expression="execution(public * com.rpm.demo..*.*(..))" />
                <aop:before method="doBefore" pointcut-ref="logMethod" />
                <aop:after method="doAfterReturning" pointcut-ref="logMethod" />
            </aop:aspect>
        </aop:config>
    **/

}
