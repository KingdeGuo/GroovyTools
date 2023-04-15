package com.kingdeguo.toolslocal.toolslocal.file.xml

/**
 * XML文件工具类
 */
class XmlFilesTools {

    /**
     * 读取XML文件
     * @param filePath
     * @return
     */
    static def getXmlFile(filePath) {
        return new XmlSlurper().parseText(filePath)
    }

}
