package com.jerrymouse.recruit.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionController {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        return new Result(StatusCode.ERROR,e.getMessage());
    }
}
