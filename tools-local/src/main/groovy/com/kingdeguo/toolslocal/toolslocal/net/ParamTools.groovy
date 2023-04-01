package com.kingdeguo.toolslocal.toolslocal.net

import com.google.common.base.Splitter
import groovy.json.JsonOutput

class ParamTools {

    static def getParam(String url, String name) {
        String params = url.substring(url.indexOf("?") + 1, url.length())
        Map<String, String> split = Splitter.on("&").withKeyValueSeparator("=").split(params)
        return split.get(name)
    }

    static def getParam_Map(String url) {
        String params = url.substring(url.indexOf("?") + 1, url.length())
        def paramMap = Splitter.on("&").withKeyValueSeparator("=").split(params)
        paramMap.each { k, v ->
            println "${k}: ${v}"
        }
    }

    static def getParam_PrettyJSON(String url) {
        String params = url.substring(url.indexOf("?") + 1, url.length())
        def paramMap = Splitter.on("&").withKeyValueSeparator("=").split(params)
        def jsonStr = JsonOutput.toJson(paramMap)
        println JsonOutput.prettyPrint(jsonStr)
        return JsonOutput.toJson(paramMap)
    }

    static void main(String[] args) {
        getParam_Map("")
    }

}
