package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.LogBean;
import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.controller.BaseController;
import com.rpm.demo.spring.beans.UserMenue;
import com.rpm.demo.spring.commons.SessionManger;

import com.rpm.demo.spring.service.redis.impl.RedisServiceimpl;
import com.rpm.demo.spring.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/21.
 */
@Controller
@RequestMapping("index")
public class HomePageController extends BaseController {

    @Autowired
    SystemService service;
    @Autowired
    MongoOperations operations;
    @Autowired
    RedisServiceimpl redisService;

    @RequestMapping("")
    public String index(HttpServletRequest request, Model model) {

        super.init(request, model);
        super.logger(new LogBean(user.toString()), level.info);
        UserMenue userMenue = null;
        try {

            //Query query = new Query();
            // query.addCriteria(new Criteria().where("userId").is(user.getId()));
            // userMenue = operations.findOne(query,UserMenue.class);
            //if (userMenue==null){
            userMenue = service.getMenues(user.getId());
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("menues", userMenue.getMenues());
        return "sys/index";
    }

    @RequestMapping("menues")
    public
    @ResponseBody
    OutBody getMeunes(HttpServletRequest request, HttpServletResponse response, Model model) {

        super.init(request, model);
        super.logger(new LogBean(user.toString()), level.info);
        UserMenue userMenue = null;
        try {

            //Query query = new Query();
            // query.addCriteria(new Criteria().where("userId").is(user.getId()));
            // userMenue = operations.findOne(query,UserMenue.class);
            //if (userMenue==null){
            userMenue = service.getMenues(user.getId());
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("menues", userMenue.getMenues());

       return  new OutBody(model.asMap());
    }
}
