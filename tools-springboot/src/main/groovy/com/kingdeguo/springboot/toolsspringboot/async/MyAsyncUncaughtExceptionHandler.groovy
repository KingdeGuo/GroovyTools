package com.kingdeguo.springboot.toolsspringboot.async

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler

import java.lang.reflect.Method

class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler{

    @Override
    void handleUncaughtException(Throwable ex, Method method, Object... params) {
        println "ExceptionHandler: ex=${ex}, method=${method}, params=${params}"
    }
}
