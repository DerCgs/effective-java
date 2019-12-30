package org.dercg.effectivejava.a_03_private_singleton;

// 实现Singleton的第三种方法，生命一个包含单个元素的枚举类型。
// 这种方式自动提供了序列化机制，即使在面对付赞的序列化或者反射攻击的时候，可以个防止多次实例化
// 如果Singleton必须扩展一个超类，而不是扩展Enum的时候，不宜使用该方法。
public enum Elvis_3 {
    INSTANCE;

    public void leaveTheBuilding(){

    }
}