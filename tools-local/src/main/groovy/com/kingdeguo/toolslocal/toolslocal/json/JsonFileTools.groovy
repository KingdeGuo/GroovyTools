package com.kingdeguo.toolslocal.toolslocal.json

import groovy.json.JsonSlurper

/**
 * JSON文件工具类
 */
class JsonFileTools {

    /**
     * 读取JSON文件
     * @param filePath
     * @return
     */
    static def getJsonFile(filePath) {
        return new JsonSlurper().parseText(filePath)
    }

    /**
     * 打印JSON文本
     * @param filePath
     * @return
     */
    static def printJsonFile(filePath) {
        println new JsonSlurper().parseText(filePath)
    }

}
