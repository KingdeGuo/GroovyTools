JDK 提供了一个工具包 javax.tools 让使用者可以用简易的 API 进行编译。
这些工具包的使用步骤：
- 获取一个 javax.tools.JavaCompiler 实例。
- 基于 Java 文件对象初始化一个编译任务 CompilationTask 实例。
- 因为JVM 里面的 Class 是基于 ClassLoader 隔离的，所以编译成功之后可以通过自定义的类加载器加载对应的类实例
- 使用反射 API 进行实例化和后续的调用。