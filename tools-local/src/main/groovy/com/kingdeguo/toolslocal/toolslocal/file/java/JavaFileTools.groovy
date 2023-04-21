package com.kingdeguo.toolslocal.toolslocal.file.java

class JavaFileTools {

    /**
     * 删除Java文件中的版权信息
     * @param filePath
     * @return
     */
    static def deleteCopyRightInfo(filePath) {
        new File(filePath).eachFileRecurse { file ->
            if (file.isFile() && file.name.endsWith('.java')) {
                println file.name
                def content = file.text.replaceAll(/\/\*\*\n \* projectName: (.+)\n \*\n \* @author: (.+)\n \* description:\n \*\//,
                        '')
                file.write(content)
            }
        }
    }

    static void main(String[] args) {
        deleteCopyRightInfo("/Users/kingdeguo/Downloads/同步空间/闲鱼/尚硅谷微服务电商毕设项目/代码/b2c-cloud-store/")
    }


}
