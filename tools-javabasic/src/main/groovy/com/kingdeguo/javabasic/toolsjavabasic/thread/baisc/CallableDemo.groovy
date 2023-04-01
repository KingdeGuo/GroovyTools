package com.kingdeguo.javabasic.toolsjavabasic.thread.baisc

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class CallableDemo {

    static void main(String[] args) {

        /**
         * callable是有返回值的
         * 一般配合线程池工具ExecutorService使用
         * */
        ExecutorService executorService = Executors.newCachedThreadPool()
        Task task = new Task()
        /**
         * Future的cancel是尝试取消, 并不一定真正的取消
         * 这里的submit方法是有返回值的, 注意使用的构造器
         * */
        Future<String> future = executorService.submit(task)
        /**
         * 调用get方法会阻塞当前线程, 直到得到结果
         * 建议使用可以设置超时时间的重载get方法
         * */
        println "result: ${future.get()}"
        executorService.shutdown()
    }

    private static class Task implements Callable<String> {

        @Override
        String call() throws Exception {
            return "Hello, world!"
        }
    }


}
