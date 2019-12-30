package org.dercg.effectivejava.a_07_clean_outtime_object;

// 消除过期对象引用
public class main {
    // 1、类自己管理内存的应该注意
    // 2、缓存，缓存容易被遗忘，从而长久的占用内存。
    // 2.1 可以使用 WeakHashMap来代表缓存。当缓存项过期后，就会自动被删除。
    // 只有当索要的缓存项生命周期是有该键的外部引用而不是由值决定时，WeakHashMap才有用。
    // 2.2 可以在新增条目时顺便出发清理缓存，或者使用后台线程ScheduleThreadPoolExecutor来清理缓存
    // 2.3 更复杂的缓存应该直接使用java.lang.ref

    // 3、内存泄漏的第三个常见来源是：监听器和其他回调。
    // 原因：客户端在api中注册回调，却没有显式的取消注册，这样他们就会不断堆积
    // 确保回调可以及时的被回收的方法是，只保存他们的弱引用，如只将他们保存成WeakHashMap中的键

    // 可以借助Heap剖析工具（Heap Profile）发现内存泄漏
}
