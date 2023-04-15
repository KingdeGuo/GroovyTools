package com.kingdeguo.toolslocal.toolslocal.file.csv

class CSVFileTools {

    /**
     * 读取csv文件
     * @param file
     * @return
     */
    static List<String> readCSVFile(File file) {
        def list = []
        file.eachLine { line ->
            list.add(line)
        }
        return list
    }

    /**
     * 读取csv文件
     * @param filePath
     * @return
     */
    static List<String> readCSVFile(String path) {
        def file = new File(path)
        return readCSVFile(file)
    }


}
