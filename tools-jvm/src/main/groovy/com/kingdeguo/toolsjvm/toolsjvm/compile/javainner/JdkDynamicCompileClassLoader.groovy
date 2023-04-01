package com.kingdeguo.toolsjvm.toolsjvm.compile.javainner

import com.kingdeguo.toolsjvm.toolsjvm.compile.CharSequenceJavaFileObject

import javax.tools.JavaFileObject
import java.util.concurrent.ConcurrentHashMap

/**
 * 因为JVM 里面的 Class 是基于 ClassLoader 隔离的，
 *  所以编译成功之后得通过自定义的类加载器加载对应的类实例，否则是加载不了的，因为同一个类只会加载一次。
 * 主要关注 findClass 方法
 * */
class JdkDynamicCompileClassLoader extends ClassLoader {

    public static final String CLASS_EXTENSION = ".class"

    private final static Map<String, JavaFileObject> javaFileObjectMap = new ConcurrentHashMap<>()

    JdkDynamicCompileClassLoader(ClassLoader parentClassLoader) {
        super(parentClassLoader)
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        JavaFileObject javaFileObject = javaFileObjectMap.get(name)
        if (null != javaFileObject) {
            CharSequenceJavaFileObject charSequenceJavaFileObject = (CharSequenceJavaFileObject) javaFileObject
            byte[] byteCode = charSequenceJavaFileObject.getByteCode()
            return defineClass(name, byteCode, 0, byteCode.length)
        }
        return super.findClass(name)
    }

    @Override
    InputStream getResourceAsStream(String name) {
        if (name.endsWith(CLASS_EXTENSION)) {
            String qualifiedClassName = name.substring(0, name.length() - CLASS_EXTENSION.length()).replace('/', '.')
            CharSequenceJavaFileObject javaFileObject = (CharSequenceJavaFileObject) javaFileObjectMap.get(qualifiedClassName)
            if (null != javaFileObject && null != javaFileObject.getByteCode()) {
                return new ByteArrayInputStream(javaFileObject.getByteCode())
            }
        }
        return super.getResourceAsStream(name)
    }

    /**
     * 暂时存放编译的源文件对象,
     * key为全类名的别名（非URI模式）, 如club.throwable.compile.HelloService
     */
    void addJavaFileObject(String qualifiedClassName, JavaFileObject javaFileObject) {
        javaFileObjectMap.put(qualifiedClassName, javaFileObject)
    }

    Collection<JavaFileObject> listJavaFileObject() {
        return Collections.unmodifiableCollection(javaFileObjectMap.values())
    }

}
