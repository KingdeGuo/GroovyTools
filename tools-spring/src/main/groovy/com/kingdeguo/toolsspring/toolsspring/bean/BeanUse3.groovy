package com.kingdeguo.toolsspring.toolsspring.bean

/**
 * 方式3:
 *  使用静态工厂方式获取
 * */
class BeanUse3 {

    private static BeanDemo bean3 = new BeanDemo()

    static BeanDemo getBean() {
        return bean3
    }

}
