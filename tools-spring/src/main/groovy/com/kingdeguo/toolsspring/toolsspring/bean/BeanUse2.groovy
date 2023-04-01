package com.kingdeguo.toolsspring.toolsspring.bean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 * 方式2:
 *  使用注解
 * */
@Service
class BeanUse2 {

    @Autowired
    @Qualifier("bean1")
    private BeanDemo bean1

}

