package com.wddjnn.user.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * http请求切面
 */
@Aspect
@Component
public class HttpAspect {
    Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(* com.wddjnn.user.controller..*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取url
        logger.info("url={}", request.getRequestURL());
        // 获取ip
        logger.info("ip={}", request.getRemoteAddr());
        // 获取处理请求的类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");
        // 获取请求方法传入的参数
        logger.info("args={}", joinPoint.getArgs());
    }

}
