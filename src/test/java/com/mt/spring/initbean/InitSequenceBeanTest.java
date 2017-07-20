package com.mt.spring.initbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by anyanwen on 2017/7/20.
 */
public class InitSequenceBeanTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    }
}
