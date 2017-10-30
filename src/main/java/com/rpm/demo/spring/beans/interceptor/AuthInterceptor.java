package com.rpm.demo.spring.beans.interceptor;

import com.rpm.demo.spring.commons.SessionManger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Observable;

/**
 * Created by gc-rise on 2017/7/21.
 * 登录权限拦截器，用户没有进行登录时进行拦截，转移到登录页面
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    public AuthInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("path" + request.getServletPath());
       // return  SessionManger.isAuth(request,response);
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("postHandle");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("postHandle");

        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
