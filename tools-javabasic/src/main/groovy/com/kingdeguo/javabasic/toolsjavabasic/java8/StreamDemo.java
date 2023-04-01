package com.kingdeguo.javabasic.toolsjavabasic.java8;

import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {

        List<String> lines = null;
        try {
            lines.stream().filter(
                    a -> a.equals("hello")
            );
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
