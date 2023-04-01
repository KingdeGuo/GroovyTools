package com.kingdeguo.toolsspring.toolsspring.bean

class BeanDemoPlus {

    def name
    def age
    BeanDemo beanDemo

    BeanDemoPlus() {}

    BeanDemoPlus(name, age, BeanDemo beanDemo) {
        this.name = name
        this.age = age
        this.beanDemo = beanDemo
    }

}
