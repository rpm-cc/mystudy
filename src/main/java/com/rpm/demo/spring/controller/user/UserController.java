package com.rpm.demo.spring.controller.user;

import com.rpm.demo.spring.beans.LogBean;
import com.rpm.demo.spring.beans.User;
import com.rpm.demo.spring.controller.BaseController;
import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.beans.exception.ParamException;

import com.rpm.demo.spring.beans.exception.UnauthenticatedException;
import com.rpm.demo.spring.commons.SessionManger;
import com.rpm.demo.spring.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    UserService service;

    @RequestMapping("login")
    public String login(HttpServletRequest request,Model model) {

         super.init(request,model);
         super.logger(new LogBean("visitor comeing "),level.info);
         return "user/login";

    }


    @RequestMapping("auth")
    public
    @ResponseBody
    OutBody auth(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        super.init(request, model);
        String userName = request.getParameter("userName") == null ? null : request.getParameter("userName").toString();
        String password = request.getParameter("password") == null ? null : request.getParameter("password").toString();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            throw new ParamException("参数错误");
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userName", userName);
        param.put("password", password);
        user = service.auth(param);
        OutBody outBody = new OutBody();
        if (user != null) {
            try {
                if (userName.equals(user.getUserName())
                        && password.equals(user.getPwd())) {


                    SessionManger.auth(request, user);
                    user.setPwd(null);
                    super.logger(new LogBean(user.toString()+" auth success"),level.info);
                    outBody.setBody(user);
                }else {
                    throw new UnauthenticatedException("用户名或密码错误");
                }
            }catch (Exception e ){
                e.printStackTrace();
            }

        } else {
            throw new UnauthenticatedException("用户名或密码错误");
        }
        return outBody;
    }


    @RequestMapping("name")
    public
    @ResponseBody
    OutBody getUserName(@RequestParam Integer id) throws Exception {

        if (id == 0) {
            throw new ParamException("参数错误，id不能为0或唯空");
        }
        OutBody outBody = new OutBody();
        System.out.printf("param id is " + id);


        try {
            String name = service.getNameById(id);
            System.out.printf("name is " + name);
            outBody.setBody(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outBody;
    }

    @RequestMapping("info")
    public
    @ResponseBody
    OutBody getUserInfoById(@RequestParam Integer id) throws Exception {
        if (id == 0) {
            throw new ParamException("参数错误，id不能为0或唯空");
        }
        OutBody outBody = new OutBody();

        try {
            User user = service.getUserInfoByid(id);
            outBody.setBody(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outBody;
    }

}
