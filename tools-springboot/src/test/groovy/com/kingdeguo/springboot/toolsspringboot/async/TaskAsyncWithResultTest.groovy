package com.kingdeguo.springboot.toolsspringboot.async

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@SpringBootTest(classes = [TaskAsyncWithResult.class, AsyncConfig.class])
@RunWith(SpringJUnit4ClassRunner.class)
class TaskAsyncWithResultTest {

    @Autowired
    private TaskAsyncWithResult taskAsyncWithResult

    @Test
    void testAsyncWithResult() {
        def start = System.currentTimeMillis()
        def task1 = taskAsyncWithResult.doTask1()
        def task2 = taskAsyncWithResult.doTask2()
        def task3 = taskAsyncWithResult.doTask3()
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break
            }
            Thread.sleep(1)
        }
        def end = System.currentTimeMillis()
        println("count: ${end - start}")

    }

}
