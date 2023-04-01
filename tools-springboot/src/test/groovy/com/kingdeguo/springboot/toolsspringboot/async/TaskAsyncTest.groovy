package com.kingdeguo.springboot.toolsspringboot.async

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = [TaskAsync.class, AsyncConfig.class])
class TaskAsyncTest {

    @Autowired
    private TaskAsync taskAsync

    @Test
    void test() {
        taskAsync.doTask1()
        taskAsync.doTask2()
        taskAsync.doTask3()
    }

}
