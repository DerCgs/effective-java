package org.dercg.effectivejava.a_07_clean_outtime_object;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++]=e;
    }

    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }

        Object obj = elements[--size];
        // TODO 因为是类Static自己维护内存elements，所以应该在元素失效时自主清空，否则内存回收器将不能回收
        //  ，最后可能有导致内存溢出的风险
        // 只要类是自己管理内存，就应该警惕内存泄漏问题
        elements[size]=null;
        return obj;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
