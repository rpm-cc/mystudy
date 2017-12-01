package com.rpm.demo.aspect.extend;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by renpiming on 2017/11/10.
 */
public class CGLIBInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method,
                            Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" 调用后"+result);
        return result;

    }
}
