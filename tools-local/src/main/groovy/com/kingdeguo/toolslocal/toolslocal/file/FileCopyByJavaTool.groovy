package com.kingdeguo.toolslocal.toolslocal.file

/**
 * 对于 Copy 的效率，这个其实与操作系统和配置等情况相关，
 * 在传统的文件IO操作里面，我们都是调用操作系统提供的底层标准IO系统调用函数 read()、write() ，
 * 由于内核指令的调用会使得当前用户线程切换到内核态，
 * 然后内核线程负责把相应的文件数据读取到内核的IO缓冲区，
 * 再把数据从内核IO缓冲区拷贝到进程的私有地址空间中去，这样便完成了一次IO操作。
 * */
class FileCopyByJavaTool {

    /**
     * 方法1:
     *   使用java.io包下的库，使用FileInputStream读取，再使用FileOutputStream写出。
     * */

    /**
     * 方法2:
     *   利用java.nio包下的库，使用transferTo或transfFrom方法实现。
     *   这也是零拷贝实现。
     * */

    /**
     * 方法3:
     *   Java 标准类库本身已经提供了 Files.copy 的实现。
     * */

}
