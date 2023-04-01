package com.kingdeguo.javabasic.toolsjavabasic.java8

class Compare {

    static void main(String[] args) {
        def demos = []
        for (it in 1..10) {
            demos.add(new CompareDemo(it, UUID.randomUUID().toString()))
        }
        Collections.sort(demos)
        demos.forEach(it -> println it)
    }

    private static class CompareDemo implements Comparable {

        private Integer id
        private String name

        @Override
        int compareTo(Object o) {
            o = (CompareDemo) o
            return name.compareTo(o.name)
        }

        CompareDemo(Integer id, String name) {
            this.id = id
            this.name = name
        }


        @Override
        String toString() {
            return "CompareDemo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}'
        }
    }

}
