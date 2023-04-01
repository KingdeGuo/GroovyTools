package com.kingdeguo.toolsspring.toolsspring.bean

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 方式1:
 *  在Java配置类中，写一个构造方法，在这个构造方法中new一个Bean实例
 *  然后在构造方法上添加注解@Bean(value="beanClass")
 *  这里的beanClass是Bean实例的名称，一般使用小驼峰命名
 *
 *  @Configuration和@Bean组合使用的目的与@Service相同, 见类: BeanUse2
 * */
@Configuration
class BeanUse1 {

    @Bean(value = "bean1")
    BeanDemo getTestBean1(){
        return new BeanDemo()
    }

}
