package com.kingdeguo.javabasic.toolsjavabasic.guava

import com.google.common.base.Splitter

class MapDemo {

    static void main(String[] args) {
        String expectedString = "key1=true, key2=false, key3=false"
        Splitter.MapSplitter mapSplitter = Splitter.on(",").trimResults().withKeyValueSeparator("=")
        Map map = mapSplitter.split(expectedString)
        println map
    }

}
