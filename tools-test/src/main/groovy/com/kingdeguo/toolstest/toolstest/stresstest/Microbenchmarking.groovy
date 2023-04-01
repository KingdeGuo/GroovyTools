package com.kingdeguo.toolstest.toolstest.stresstest

class Microbenchmarking {

    static int nLoop = 100

    void doTest() {
        double l
        long then = System.currentTimeMillis()
        for (int i = 0; i < nLoop; i++) {
            l = fibImpl(30)
        }
        long now = System.currentTimeMillis()
        println "coast: ${now - then}"
    }

    private double fibImpl(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive number")
        }
         if (n == 0) {
             return 0.0
         }
        if (n == 1) {
            return 1.0
        }
        double d = fibImpl(n - 1) + fibImpl(n - 2)
//        if (Double.isFinite(d)) {
//            throw new ArithmeticException("Overflow in fibImpl")
//        }
        return d
    }

}
