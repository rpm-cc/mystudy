package com.rpm.demo.spring.controller;

import com.rpm.demo.spring.beans.LogBean;
import com.rpm.demo.spring.beans.User;
import com.rpm.demo.spring.commons.SessionManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 * 进行公共参数的赋值。添加所有可能在页面中使用到的值到model中。
 * 同时进行一些通用方法的编写.
 * 定义为abstract.预留出扩展空间
 */
public abstract class BaseController {


    protected User user;
    protected String host;
    protected String ip;
    protected Logger logger = null;

    protected enum level {
        debug, info, warn, error
    }

    ;

    protected void init(HttpServletRequest request, Model model) {
        logger = LoggerFactory.getLogger(request.getServletPath());
        user = SessionManger.getAuthor(request);
        ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        host=request.getServerName();
        int port = request.getServerPort();
        if (port >80) {
            host = "http://" + host + ":" + port;
        } else {
            host = "http://" + host;
        }
        model.addAttribute("user", user);
        model.addAttribute("ip", ip);
        model.addAttribute("host", host);
    }

    protected void logger(LogBean logBean, level level) {
        String log = logBean.toString();
        switch (level) {
            case debug:
                logger.debug(log);
                break;
            case info:
                logger.info(log);
                break;
            case warn:
                logger.warn(log);
                break;
            case error:
                logger.error(log);
                break;
        }

    }


}
