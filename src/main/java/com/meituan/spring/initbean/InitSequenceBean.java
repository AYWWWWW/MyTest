package com.meituan.spring.initbean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * created by anyanwen on 2017/7/20.
 */
@Component
public class InitSequenceBean implements InitializingBean {

    private boolean properties;

    public InitSequenceBean() {
        System.out.println("InitSequenceBean constructor");
    }

    public void setProperties(boolean properties) {
        System.out.println("InitSequenceBean set properties");
        this.properties = properties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitSequenceBean afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitSequenceBean postConstruct");
    }

    public void initMethod() {
        System.out.println("InitSequenceBean initMethod");
    }

    public boolean isProperties() {
        return properties;
    }

    public static void main(String[] args) {
    }
}
