package com.kingdeguo.toolslocal.toolslocal.client

import java.util.concurrent.ThreadLocalRandom

class RandomTool {

    private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.newInstance()

    static void main(String[] args) {
        println nextInt(100)
    }

    static def nextInt() {
        threadLocalRandom.nextInt()
    }

    static def nextInt(def bound) {
        threadLocalRandom.nextInt(bound)
    }

}
