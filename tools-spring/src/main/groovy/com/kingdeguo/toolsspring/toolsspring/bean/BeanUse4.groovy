package com.kingdeguo.toolsspring.toolsspring.bean

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * 方式4:
 *  从xml文件中获取-参数名称注入
 * */
class BeanUse4 {

    static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beanUse.xml")
        def bean = ac.getBean("bean4")
        println bean.code
        println bean.msg
    }

}
