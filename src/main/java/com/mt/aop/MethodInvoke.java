package com.mt.aop;

/**
 * created by anyanwen on 2017/7/17.
 */
public class MethodInvoke {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        Foo foo = new Foo();
                        foo.foo();
                    }
                }
            }).start();
        }
    }
}
