# Springboot中的异步调用
## 写在前面
- 如何学习这部分内容: 其实官方的文档写的已经很清楚了.看@EnableAsync, @Async这两个注解的文档基本就可以了.

## 注意事项
- “异步调用”对应的是“同步调用”，同步调用指程序按照定义顺序依次执行，每一行程序都必须等待上一行程序执行完成之后才能执行；异步调用指程序在顺序执行时，不等待异步调用的语句返回结果就执行后面的程序。
- 为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync，
- @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
- @Async描述的方法底层会异步执行(不由web服务线程执行, 而是交给spring自带的线程池中的线程去执行。优点在于不会长时间阻塞web服务(例如tomcat)线程
- @Async注解一般用在类的方法上，如果用在类上，那么这个类所有的方法都是异步执行的
- 所使用的@Async注解方法的类对象应该是Spring容器管理的bean对象；
- 默认情况下（即@EnableAsync注解的mode=AdviceMode.PROXY），同一个类内部没有使用@Async注解修饰的方法调用@Async注解修饰的方法，是不会异步执行的，这点跟 @Transitional 注解类似，底层都是通过动态代理实现的。如果想实现类内部自调用也可以异步，则需要切换@EnableAsync注解的mode=AdviceMode.ASPECTJ，详见@EnableAsync注解。
- 任意参数类型都是支持的，但是方法返回值必须是void或者Future类型。当使用Future时，你可以使用 实现了Future接口的ListenableFuture接口或者CompletableFuture类与异步任务做更好的交互。如果异步方法有返回值，没有使用Future<V>类型的话，调用方获取不到返回值。
- however, that @Async is not supported on methods declared within a @Configuration class
- @EnableAsync（默认mode为AdviceMode.PROXY情况下）作用为了给spring项目加入AsyncConfigurationSelector，从而引入AsyncAnnotationBeanPostProcessor。

## 好文推荐
- https://cloud.tencent.com/developer/article/1426027
- https://developer.aliyun.com/article/768513
- https://juejin.cn/post/6858854987280809997
- https://www.cnblogs.com/yangxiaohui227/p/14831911.html
- https://segmentfault.com/a/1190000023334027
- https://zhuanlan.zhihu.com/p/439879500
- https://zhuanlan.zhihu.com/p/149836875