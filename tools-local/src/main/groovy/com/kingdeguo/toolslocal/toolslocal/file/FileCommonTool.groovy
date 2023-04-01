package com.kingdeguo.toolslocal.toolslocal.file

import com.kingdeguo.toolslocal.toolslocal.file.txt.TxtFileTools

class FileCommonTool {

    static void main(String[] args) {
        def files = getFilesInRecurseMode(".")
        println files
    }

    static def getFile(def file) {
        if (file instanceof String) {
            file = new File(file)
        } else if (!(file instanceof File)) {
            throw new Exception("错误的参数. 参数应为String or File")
        }
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    static def copyFile(def src, def dest) {
        src = FileCommonTool.getFile(src)
        dest = FileCommonTool.getFile(dest)
        dest << TxtFileTools.getWholeFile(src)
        return dest
    }

    static def deleteFile(def file) {
        file = FileCommonTool.getFile(file)
        file.delete()
    }

    static def getFiles(def file) {
        file = getFile(file)
        def res = []
        file.eachFile {
            res.add(it)
        }
        return res
    }

    static def getDirs(def file) {
        file = getFile(file)
        def res = []
        file.eachDir {
            res.add(it)
        }
        return res
    }

    static def getFilesInRecurseMode(def file) {
        file = getFile(file)
        def res = []
        file.eachFileRecurse {
            res.add(it)
        }
        return res
    }

    static def getDirsInRecurseMode(def file) {
        file = getFile(file)
        def res = []
        file.eachDirRecurse {
            res.add(it)
        }
        return res
    }

    static def getDirsWithoutFileInRecurseMode(def file) {
        file = getFile(file)
        def res = []
        file.eachDirRecurse {
            res.add(it)
        }
        return res
    }

}
