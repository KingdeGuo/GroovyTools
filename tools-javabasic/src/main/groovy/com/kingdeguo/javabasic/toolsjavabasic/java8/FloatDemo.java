package com.kingdeguo.javabasic.toolsjavabasic.java8;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class FloatDemo {

    public static void main(String[] args) {
        Info info = new Info();
        info.setWeight(Float.valueOf("64.3"));

        Map<String, Object> map = new HashMap<>();
        map.put("weight", info.getWeight());
        System.out.println(map.get("weight").toString());
    }

    @Getter
    @Setter
    private static class Info {
        private Float weight;
    }

}
