package com.kingdeguo.toolsjvm.toolsjvm.compile

/**
 * 如果编译成功之后
 *  直接通过 CharSequenceJavaFileObject#getByteCode()方法即可获取目标类编译后的字节码对应的字节数组（二进制内容）
 * */
import javax.tools.SimpleJavaFileObject

class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    public static final String CLASS_EXTENSION = ".class"

    private final CharSequence sourceCode

    public static final String JAVA_EXTENSION = ".java"

    private ByteArrayOutputStream byteCode

    private static URI fromClassName(String className) {
        try {
            return new URI(className)
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(className, e)
        }
    }

    CharSequenceJavaFileObject(String className, CharSequence sourceCode) {
        super(fromClassName(className + JAVA_EXTENSION), Kind.SOURCE)
        this.sourceCode = sourceCode
    }

    CharSequenceJavaFileObject(String fullClassName, Kind kind) {
        super(fromClassName(fullClassName), kind)
        this.sourceCode = null
    }

    CharSequenceJavaFileObject(URI uri, Kind kind) {
        super(uri, kind)
        this.sourceCode = null
    }

    @Override
    CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return sourceCode
    }

    @Override
    InputStream openInputStream() {
        return new ByteArrayInputStream(getByteCode())
    }

    /**
     * 注意这个方法是编译结果回调的OutputStream，
     * 回调成功后就能通过下面的getByteCode()方法获取目标类编译后的字节码字节数组
     * */
    @Override
    OutputStream openOutputStream() {
        return byteCode = new ByteArrayOutputStream()
    }

    byte[] getByteCode() {
        return byteCode.toByteArray()
    }
}
