package com.kingdeguo.springboot.toolsspringboot.async

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import java.util.concurrent.Executor

// todo
@EnableAsync
@Configuration
class AsyncConfig implements AsyncConfigurer{

    @Bean
    TaskAsync asyncBean(){
        return new TaskAsync()
    }

    @Override
    Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor()
        executor.setCorePoolSize(7)
        executor.setMaxPoolSize(42)
        executor.setQueueCapacity(11)
        executor.setThreadNamePrefix("MyExecutor-")
        executor.initialize()
        return executor
    }

    @Override
    AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler()
    }
}
