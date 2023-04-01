package com.kingdeguo.javabasic.toolsjavabasic.thread.baisc

class ThreadMethod {

    static void main(String[] args) {
        def thread = new ThreadMethodDemo()
        thread.start()
        Byte
    }

    private static class ThreadMethodDemo extends Thread {
        @Override
        void run() {
            println "current thread: ${currentThread()}"
            println "Running"
            // 当前线程自愿让出对处理器的占用
            yield()
            // 当前线程等待另一个线程完毕之后再继续执行
            // 内部是调用Object的wait()实现的
//            currentThread().join()
        }
    }

}
