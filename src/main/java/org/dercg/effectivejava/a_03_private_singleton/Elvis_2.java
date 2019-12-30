package org.dercg.effectivejava.a_03_private_singleton;

import java.io.Serializable;

public class Elvis_2 implements Serializable {
    private static final Elvis_2 INSTANCE = new Elvis_2();

    private Elvis_2(){

    }
    // 此处采用静态工厂方式的优势
    // 1、灵活性。在不改变API的前提下，可以改变该类是否应该为Singleton的想法。如：每个调用该方法的线程返回一个唯一的实例
    // 2、可以编写一个泛型Singleton工厂。
    // 3、可以通过方法引用作为提供者。如：Elvis::instance 传参
    public static Elvis_2 getInstance(){
        return INSTANCE;
    }
}
