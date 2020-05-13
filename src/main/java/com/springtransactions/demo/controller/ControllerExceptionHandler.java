package com.springtransactions.demo.controller;

import com.springtransactions.demo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleException(Exception e){
        log.error("Handling Not Found exception");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("404error");
        return mv;
    }
}