package org.dercg.effectivejava.a_06_immutable_object;

import java.util.regex.Pattern;
// 避免创建不必要的对象
public class main {
    // 创建Pattern实例的成本很高，因为需要将正则表达式编译成一个有限状态机。
    // 将pattern成为类初始化的一部分，并缓存起来，每次调用时重用。可以显著提高性能
    private static final Pattern pattern = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return pattern.matcher(s).matches();
    }

    // 要优先使用基本类型，而不是装箱基本类型，小心无意识的自动装箱。

    // 对象池的方法可以避免创建不必要的对象，但是 除非对象的创建成本很好，如数据库连接，则不要使用对象池。
    // 滥用对象池 1.使代码变得很乱 2.占用内存
    // 现代JVM的高度优化的垃圾回收器，性能很容易超过轻量级对象池的性能。
}
