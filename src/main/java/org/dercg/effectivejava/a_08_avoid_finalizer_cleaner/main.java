package org.dercg.effectivejava.a_08_avoid_finalizer_cleaner;

public class main {
    // 如果类的对象中封装的资源（ex:文件或者线程）确实需要终止，则应该让类实现AutoCloseable，并要求客户端在每个实例
    // 不再需要的时候调用close方法，一般利用try-with-resources 确保终止。
    // 实践中，该实例必须记录下自己是否已经被关闭：close方法在一个私有域中记录下‘该记录已经不再有效’的状态，
    // 如果这些方法在对象被终止之后被调用，其他方法就必须检查这个域，并抛出IllegalStateException异常。


}
