package com.springtransactions.demo.customConfigurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class CustomAspect {

    @Before("execution(* com.springtransactions.demo.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("Inside method -> "+joinPoint.getSignature());
    }
}
