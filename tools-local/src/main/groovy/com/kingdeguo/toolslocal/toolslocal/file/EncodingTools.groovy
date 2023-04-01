package com.kingdeguo.toolslocal.toolslocal.file

import groovy.json.StringEscapeUtils

class EncodingTools {

    static def unescapeJava(String oriStr) {
        return StringEscapeUtils.unescapeJava(oriStr)
    }

    static def escapeJava(String oriStr) {
        return StringEscapeUtils.escapeJava(oriStr)
    }

    static void main(String[] args) {
        println unescapeJava("{}")
    }

}
