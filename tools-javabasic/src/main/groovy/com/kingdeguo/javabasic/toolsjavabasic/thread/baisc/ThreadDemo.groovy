package com.kingdeguo.javabasic.toolsjavabasic.thread.baisc

class ThreadDemo {

    static void main(String[] args) {
        def myThread = new MyThread()
        /**
         * 调用start()方法后, 虚拟机会先创建一个线程
         * 等到这个线程被分到时间片后, 就会执行run()方法
         *
         * 如果线程的状态不对, 则无法执行
         * 执行之前将线程加入到线程组
         * 将要执行的线程数量加1
         * 不准备执行的线程数量减1
         * */
        myThread.start()

        /**
         * 执行过一次之后无法再次调用start()方法
         * 会抛出 IllegalThreadStateException
         * */
//        myThread.start()

        /**
         * 关注Thread类的构造方法
         * init(ThreadGroup g, Runnable target, String name, long stackSize, AccessControlContext acc, boolean inheritThreadLocals)
         *
         * */
        def thread2 = new Thread(() ->
                println "Hello, I run"
        , "MyThread's Name").start()

    }

    private static class MyThread extends Thread {
        @Override
        void run() {
            println "Hello, I am running"
        }
    }

}

