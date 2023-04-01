package com.kingdeguo.javabasic.toolsjavabasic.thread.baisc

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class FutureDemo {

    static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool()
        /**
         * FutureTask同时实现了Future和Runnable
         * 在高饼发情况下, FutureTask可能被创建了多个, 但是能保证任务只执行一次
         * 源码中可以看到FutureTask的几种状态
         * */
        FutureTask<String> futureTask = new FutureTask<String>(new MyFutureDemo())
        // 注意这里的submit方法是没有返回值的, 注意使用的构造器
        executorService.submit(futureTask)
        println "ans: ${futureTask.get()}"
        executorService.shutdown()
    }

    private static class MyFutureDemo implements Callable<String> {

        @Override
        String call() throws Exception {
            return "Hello"
        }
    }

}
