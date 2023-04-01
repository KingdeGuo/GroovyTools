package com.kingdeguo.toolsspring.toolsspring.bean

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * 方式6:
 *  从xml文件中获取-默认参数顺序注入
 * */
class BeanUse6 {

    static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beanUse.xml")
        def bean = ac.getBean("bean6")
        println bean.name
        println bean.age
    }

}
