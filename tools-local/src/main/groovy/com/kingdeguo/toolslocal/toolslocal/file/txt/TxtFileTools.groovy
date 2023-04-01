package com.kingdeguo.toolslocal.toolslocal.file.txt

import com.kingdeguo.toolslocal.toolslocal.file.FileCommonTool

import java.util.stream.Collectors

class TxtFileTools {

    static def getEachLine(def file) {
        file = FileCommonTool.getFile(file)
        def lines = []
        file.eachLine {
            line -> lines.add(line)
        }
        return lines
    }

    static def getEachLineDistant(def file) {
        file = FileCommonTool.getFile(file)
        def lines = []
        file.eachLine {
            line -> lines.add(line)
        }
        lines = lines.stream().distinct().collect(Collectors.toList())
        return lines
    }

    static def getEachLineWithFilter(def file, def filter) {
        throw new Exception("还没有实现")
    }

    static def getWholeFile(def file) {
        file = FileCommonTool.getFile(file)
        if (file.exists() && file.canRead()) {
            return file.text
        } else {
            println "文件不存在或不允许写入"
        }
    }

    static void writeLine(def fileName, def content) {
        /**
         * 会清楚掉文件原来的内容
         * */
        File file = FileCommonTool.getFile(fileName)
        if (file.exists() && file.canWrite()) {
            file.withWriter('utf-8') {
                writer -> writer.writeLine(content)
            }
        } else {
            println "文件不存在或不允许写入"
        }
    }

    static void append(def file, def content) {
        file = FileCommonTool.getFile(file)
        if (file.exists() && file.canWrite()) {
            file << content
        }
    }

    static void appendLine(def file, def content) {
        append(file, content + "\n")
    }


    static void addStar(def file, def star) {
        def lines = getEachLine(file)
        FileCommonTool.deleteFile(file)
        lines.forEach(it -> {
            appendLine(file, it + ",")
        })
    }

    static void main(String[] args) {
        addStar("", ",")
    }


}
