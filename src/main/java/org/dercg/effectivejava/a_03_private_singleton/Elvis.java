package org.dercg.effectivejava.a_03_private_singleton;

// Singleton with public final field
public class Elvis {
    // 私有构造器仅被调用一次，用来实例化INSTANCE，从而保证Elvis的全局唯一性。
    // 享有特权的客户端可以借助 AccessibleObject.setAccessible方法，通过反射机制调用私有构造器。
    // 要避免这种通过反射创建实例的情况，可以修改构造器，让在被要求创建第二个实例的时候抛出异常。
    public static final Elvis INSTANCE = new Elvis();

    private Elvis(){

    }
}
