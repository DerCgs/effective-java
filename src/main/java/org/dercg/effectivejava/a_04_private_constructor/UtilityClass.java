package org.dercg.effectivejava.a_04_private_constructor;

// 当类不包含显示的构造器的时候，编译器会生成缺省的构造器，为了确保类不可被实例化，可以包含一个私有的构造器
public class UtilityClass {
    // Suppress default constructor of noninstantiability
    private UtilityClass(){
        throw new AssertionError();
    }
}
