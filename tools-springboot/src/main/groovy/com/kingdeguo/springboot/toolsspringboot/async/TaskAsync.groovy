package com.kingdeguo.springboot.toolsspringboot.async

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

import java.util.concurrent.ThreadLocalRandom

@Component
class TaskAsync {

    private static ThreadLocalRandom threadLocalRandom = new ThreadLocalRandom()

    // todo
    @Async
    void doTask1() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
    }

    @Async
    void doTask2() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
    }

    @Async
    void doTask3() {
        def start = System.currentTimeMillis()
        println "start: ${start}"
        Thread.sleep(threadLocalRandom.nextInt(1000))
        def end = System.currentTimeMillis()
        println "end: ${end}"
        println "count: ${end - start}"
    }

}
