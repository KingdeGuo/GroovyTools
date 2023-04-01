package com.kingdeguo.javabasic.toolsjavabasic.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("2222abcd,5555abcd");
        list.add("6666abcd,1111abcd");
        list.add("5555abcd,6666abcd");
        list.add("1111abcd,7777abcd");

        Set<String> collect = list.stream()
                .map(item -> item.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
        System.out.println(collect.toString().replaceAll("[\\[\\]]", "\""));
    }

}
