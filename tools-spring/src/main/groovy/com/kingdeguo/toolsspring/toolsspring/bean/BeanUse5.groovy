package com.kingdeguo.toolsspring.toolsspring.bean

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * 方式5:
 *  从xml文件中获取-参数下标注入
 * */
class BeanUse5 {

    static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beanUse.xml")
        def bean = ac.getBean("bean5")
        println bean.name
        println bean.age
    }

}
