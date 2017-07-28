package com.im4j.handler;

import com.alibaba.fastjson.JSONObject;
import com.im4j.cmmon.Result;
import com.im4j.exception.ClientException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzp on 2017/7/27 0027.
 */
@Aspect
@Component
public class ExceptionHandler {

    @Around("within(com.im4j.controller.*)")
    public Object  handleException(ProceedingJoinPoint p) {
        Object o = null;
        try {
            o = p.proceed();
        }catch (Throwable e){
            if(e instanceof ClientException){
                return Result.getErrorInstance(e.getMessage());
            }
        }
        return o;
    }
}
