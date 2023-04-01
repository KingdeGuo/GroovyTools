package com.kingdeguo.toolsjvm.toolsjvm.compile.javainner

import com.kingdeguo.toolsjvm.toolsjvm.compile.CharSequenceJavaFileObject

import javax.tools.DiagnosticCollector
import javax.tools.JavaCompiler
import javax.tools.JavaFileObject
import javax.tools.StandardJavaFileManager
import javax.tools.StandardLocation
import javax.tools.ToolProvider

final class JdkCompiler {

    /**
     * https://docs.oracle.com/javase/8/docs/api/javax/tools/DiagnosticCollector.html
     * */
    static DiagnosticCollector<JavaFileObject> DIAGNOSTIC_COLLECTOR = new DiagnosticCollector<>()

    @SuppressWarnings("unchecked")
    static <T> T compile(String packageName,
                                String className,
                                String sourceCode) throws Exception {
        // 获取系统编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler()
        // 获取标准的Java文件管理器实例
        StandardJavaFileManager manager = compiler.getStandardFileManager(DIAGNOSTIC_COLLECTOR, null, null)
        // 初始化自定义类加载器
        JdkDynamicCompileClassLoader classLoader = new JdkDynamicCompileClassLoader(Thread.currentThread().getContextClassLoader())
        // 初始化自定义Java文件管理器实例
        JdkDynamicCompileJavaFileManager fileManager = new JdkDynamicCompileJavaFileManager(manager, classLoader)
        String qualifiedName = packageName + "." + className
        // 构建Java源文件实例
        CharSequenceJavaFileObject javaFileObject = new CharSequenceJavaFileObject(className, sourceCode)
        // 添加Java源文件实例到自定义Java文件管理器实例中
        fileManager.addJavaFileObject(
                StandardLocation.SOURCE_PATH,
                packageName,
                className + CharSequenceJavaFileObject.JAVA_EXTENSION,
                javaFileObject
        )
        // 设置编译参数
        List<String> options = ["-source", "1.8", "-target", "1.8"]
        // 初始化一个编译任务实例
        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null,
                fileManager,
                DIAGNOSTIC_COLLECTOR,
                options,
                null,
                Collections.singletonList(javaFileObject)
        )
        Boolean result = compilationTask.call()
        System.out.println(String.format("编译[%s]结果:%s", qualifiedName, result))
        Class<?> klass = classLoader.loadClass(qualifiedName)
        return (T) klass.getDeclaredConstructor().newInstance()
    }
}
