package com.kingdeguo.toolscrawler.web

import org.jsoup.Jsoup

class HtmlTools {

    static def getWebRawText(String url) {
        def text = new URL(url).text
        return text
    }

    static def getWebText(String url) {
        def doc = Jsoup.connect(url).get()
        def text = doc.text()
        return text
    }

    static void main(String[] args) {
        println getWebText("https://www.baidu.com")
    }

}
