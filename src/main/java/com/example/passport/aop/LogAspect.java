package com.example.passport.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class LogAspect {
    private Map<String, Object> logInfo = new HashMap<String, Object>();
    @Pointcut("execution(public * com.example.passport.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinpoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        logInfo.put("method", request.getMethod());
        logInfo.put("url", request.getRequestURL());

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(logInfo);
        log.info(jsonStr);
    }
}
