package com.kingdeguo.toolslocal.toolslocal.json

import groovy.json.JsonSlurper

class JSONTools {

    private static def jsonSlurper = new JsonSlurper()

    static def parseText(def content){
        return jsonSlurper.parseText(content)
    }

}
