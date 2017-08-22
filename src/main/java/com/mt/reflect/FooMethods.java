package com.mt.reflect;

/**
 * created by anyanwen on 2017/8/1.
 */
public class FooMethods {
    public void foo(Object[] param, Object result) {
        System.out.println("foo with param and result");
    }

    public void foo(Object result) {
        System.out.println("foo with result");
    }

    public void foo(Object[] param) {
        System.out.println("foo with param");
    }
}
