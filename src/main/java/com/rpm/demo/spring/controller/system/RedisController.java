package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.beans.User;
import com.rpm.demo.spring.controller.BaseController;
import com.rpm.demo.spring.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created by renpiming on 2017/10/30.
 */
@Controller
@RequestMapping("redis")
public class RedisController extends BaseController {
    @Autowired
    RedisService redis;
    @Autowired
    RedisTemplate<String,String> template;

    @RequestMapping("set")
    public @ResponseBody
    OutBody set(HttpServletRequest request, HttpServletResponse response, @RequestParam  String key,String value){
        template.opsForValue().set(key,value);
        OutBody outBody = new OutBody();
        outBody.setBody("key="+key+"   value="+value);
        return outBody;
    }
    @RequestMapping("setNx")
    public @ResponseBody
    OutBody setNx(HttpServletRequest request, HttpServletResponse response, @RequestParam  String key,String value){
        template.opsForValue().set(key,value,500, TimeUnit.SECONDS);
        OutBody outBody = new OutBody();
        outBody.setBody("key="+key+"   value="+value);
        return outBody;
    }
    @RequestMapping("get")
    public @ResponseBody OutBody get(HttpServletRequest request, HttpServletResponse response, @RequestParam  String key){
        String value  =  template.opsForValue().get(key);
        OutBody outBody = new OutBody();
        outBody.setBody(value);
        return outBody;

    }


}
