package com.rpm.demo.spring.commons;

import com.rpm.demo.spring.beans.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/24.
 * session 管理类。httpsession 经过spring-session 的重写，会将session 存放在redis中。
 *
 */
public class SessionManger {

    static Logger logger = LoggerFactory.getLogger("sessionManager");
    public static boolean isAuth(HttpServletRequest request, HttpServletResponse response) {
        User user  = getAuthor(request);
        if (user!=null
                &&user.getId()!=0
                && StringUtils.isNotEmpty(user.getUserName())) {
            return true;
        } else {

            logger.info("invalid visitor");
            try {
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static void auth(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("user",user);

    }

    public static User getAuthor(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        return user;

    }
}
