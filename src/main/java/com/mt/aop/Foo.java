package com.mt.aop;

import org.springframework.stereotype.Component;

/**
 * created by anyanwen on 2017/7/17.
 */
@Component
public class Foo {
    public void foo() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
