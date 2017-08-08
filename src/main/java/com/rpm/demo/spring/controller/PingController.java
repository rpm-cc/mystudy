package com.rpm.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/13.
 */

@Controller
public class PingController {

    @RequestMapping("ping")
    public void ping(HttpServletRequest request, HttpServletResponse response, Model model){

        System.out.printf("ping success");

        try {
            response.getWriter().write("ping sueecss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("view")
    public String view(HttpServletRequest request,HttpServletResponse response){
        //view 对应的是WEB-INF/view/view1
        return "view1";
    }


}
