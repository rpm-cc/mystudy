package com.rpm.demo.spring.beans.exception;

import com.rpm.demo.spring.beans.OutBody;
import com.rpm.demo.spring.beans.exception.BusinessException;
import com.rpm.demo.spring.beans.exception.ParamException;
import com.rpm.demo.spring.beans.exception.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created by gc-rise on 2017/7/13.
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ParamException.class)
    public @ResponseBody
    OutBody ApiParamExceptionHandler(ParamException ex) {
        OutBody returnBean = new OutBody();
        returnBean.setStatus(ex.getCode());
        returnBean.setMsg(ex.getMsg());
        return returnBean;
    }

    @ExceptionHandler(BusinessException.class)
    public @ResponseBody OutBody ApiBusinessExceptionHandler(BusinessException ex) {
        OutBody returnBean = new OutBody();
        returnBean.setStatus(ex.getCode());
        returnBean.setMsg(ex.getMsg());
        return returnBean;
    }
    @ExceptionHandler(UnauthenticatedException.class)
    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody OutBody processUnauthenticatedException(NativeWebRequest request, UnauthenticatedException ex) {
        OutBody returnBean = new OutBody();
        returnBean.setStatus(ex.getCode());
        returnBean.setMsg(ex.getMsg());
        return returnBean;

    }
}
