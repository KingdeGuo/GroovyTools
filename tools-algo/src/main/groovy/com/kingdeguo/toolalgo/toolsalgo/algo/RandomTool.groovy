package com.kingdeguo.toolalgo.toolsalgo.algo

/**
 * 一般情况下可能想到的是 Random, 但考虑到对性能的极致追求, 考虑使用 ThreadLocalRandom 类进行优化
 * Random存在的问题
 *   使用 Random 类时，为了避免重复创建的开销，
 *   我们一般将实例化好的 Random 对象设置为我们所使用服务对象的属性或静态属性，
 *   这在线程竞争不激烈的情况下没有问题，
 *   但在一个高并发的 web 服务内，使用同一个 Random 对象可能会导致线程阻塞。
 * Random 的随机原理是对一个”随机种子”进行固定的算术和位运算，
 *  得到随机结果，再使用这个结果作为下一次随机的种子。
 *  在解决线程安全问题时，Random 使用 CAS 更新下一次随机的种子，
 *  可以想到，如果多个线程同时使用这个对象，
 *  就肯定会有一些线程执行 CAS 连续失败，进而导致线程阻塞。
 * */
class RandomTool {



}
