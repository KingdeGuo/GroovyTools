package com.kingdeguo.toolsspring.toolsspring.bean

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

class BeanDemo {

    def code
    def msg

    BeanDemo() {
        println "BeanDemo Init"
    }

    BeanDemo(code, msg) {
        this.code = code
        this.msg = msg
    }
}
