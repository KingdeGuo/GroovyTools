package com.kingdeguo.javabasic.toolsjavabasic.thread.baisc

class RunnableDemo {

    static void main(String[] args) {

        def myRunnable = new MyRunnable()
        // 这样做是因为thread子类只有run方法, 无法调用start方法启动线程
        def myThread = new Thread(myRunnable)
        myThread.start()
        // 因为Thread是一个函数式接口, 因此可以像下面这样实现它
        new Thread(() ->
                println "Hello, I run again"
        ).start()


    }

    private static class MyRunnable implements Runnable {

        @Override
        void run() {
            println "Hello, I run"
        }
    }

}
