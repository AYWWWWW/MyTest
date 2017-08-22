package com.mt.reflect;

import java.lang.reflect.Method;

/**
 * created by anyanwen on 2017/8/1.
 */
public class MethodReflect {
    public static void main(String[] args) throws Exception {
        Class clazz = com.mt.reflect.FooMethods.class;
        Method method = clazz.getDeclaredMethod("foo", new Class[] { Object[].class, Object.class });
        method.invoke(clazz.newInstance(), null, null);
    }
}
