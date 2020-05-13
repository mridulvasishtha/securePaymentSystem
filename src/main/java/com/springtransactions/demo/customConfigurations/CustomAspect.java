package com.springtransactions.demo.customConfigurations;

import com.springtransactions.demo.delete.FinalObjectComponent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Aspect
@Configuration
@Slf4j
public class CustomAspect {

    @Before("execution(* com.springtransactions.demo.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("Inside method -> "+joinPoint.getSignature());
    }

    @Bean
    @Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public FinalObjectComponent getFinalObject() {
        return new FinalObjectComponent();
    }
}
