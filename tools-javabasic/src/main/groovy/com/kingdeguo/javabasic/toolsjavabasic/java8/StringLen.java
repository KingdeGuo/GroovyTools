package com.kingdeguo.javabasic.toolsjavabasic.java8;

public class StringLen {

    public static void main(String[] args) {

        System.out.println("你好".length());
        System.out.println("崔芳".length());
        System.out.println("秦玉航".length());
        System.out.println("秦a玉b航c".length());
        String name = "今天是一个好天气";
        System.out.println(name.substring(0, 5) + "...");
    }

}
