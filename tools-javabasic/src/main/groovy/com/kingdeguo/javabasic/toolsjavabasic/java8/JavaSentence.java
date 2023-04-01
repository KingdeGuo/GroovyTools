package com.kingdeguo.javabasic.toolsjavabasic.java8;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class JavaSentence {


    public static void main(String[] args) {
        Inner inner = new Inner();
//        int age = null != inner.getAge() ? inner.getAge().intValue() : 0;
//        int age = null != inner.getAge() ? 0 : inner.getAge().intValue();
//        System.out.println(age);
//
//        Long id = 5 > 3 ? 0L : null;

//        Integer age = null != inner.getAge() ? inner.getAge() : 0;
//        Integer age = null != inner.getAge() ? 0 : inner.getAge();

//        Long id = 5 > 3 ? 0L : null;
        Long id = 5 > 3 ? null: 0L;
    }

    static class Inner {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }


}
