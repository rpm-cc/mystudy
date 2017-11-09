package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.commons.MD5Util;
import com.rpm.demo.spring.commons.Signature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by renpiming on 2017/11/1.
 */


@Controller
@RequestMapping("request")
public class RequestController {

    @RequestMapping("/info")
    public @ResponseBody
    OutBody info(HttpServletRequest request, HttpServletResponse response) {

        String token = request.getHeader("token");
        String accessKey = request.getParameter("accessKey");
        OutBody outBody = new OutBody();
        if (token.equals(new Signature().postSignature(accessKey, Signature.SECRETKEY))) {

            outBody.setBody("access sucess!");
        } else {
            outBody.setBody("access failed");
        }


        return outBody;
    }


}
