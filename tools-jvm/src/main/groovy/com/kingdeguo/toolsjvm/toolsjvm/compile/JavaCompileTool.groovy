package com.kingdeguo.toolsjvm.toolsjvm.compile

import com.kingdeguo.toolsjvm.toolsjvm.compile.javainner.JdkCompiler

/**
 * https://www.cnblogs.com/hbuwdx/p/9489177.html
 * */
class JavaCompileTool {

    static def saveAndGetObject(String packageName, String className, String javaContent) throws Exception {
        return JdkCompiler.compile(packageName, className, javaContent)
    }

}
