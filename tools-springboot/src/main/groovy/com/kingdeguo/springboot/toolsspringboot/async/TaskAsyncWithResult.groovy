package com.kingdeguo.springboot.toolsspringboot.async

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Component

import java.util.concurrent.Future
import java.util.concurrent.ThreadLocalRandom

@Component
class TaskAsyncWithResult {

    private static ThreadLocalRandom threadLocalRandom = new ThreadLocalRandom()

    @Async
    Future<String> doTask1() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
        return new AsyncResult<String>("task1 ok")
    }

    @Async
    Future<String> doTask2() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
        return new AsyncResult<>("task2 ok")
    }

    @Async
    Future<String> doTask3() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
        return new AsyncResult<>("task3 ok")
    }


}
