package com.kingdeguo.javabasic.toolsjavabasic.guava

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table

class HashBasedTableDemo {

    static void main(String[] args) {

        Table<String, String, String> table = HashBasedTable.create()
        table.put("1", "a", "第1组第a个数据")
        table.put("1", "b", "第1组第b个数据")
        table.put("2", "a", "第2组第a个数据")
        table.put("2", "b", "第2组第b个数据")

        System.out.println(table.get("1", "a"))
        System.out.println(table.get("1", "b"))
        System.out.println(table.get("2", "a"))
        System.out.println(table.get("2", "b"))
        System.out.println(table.get("2", "b"))

    }

}
