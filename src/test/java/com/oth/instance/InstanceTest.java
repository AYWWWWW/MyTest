package com.oth.instance;

import org.junit.Assert;
import org.junit.Test;

/**
 * created by anyanwen on 2017/8/1.
 */
public class InstanceTest {
    @Test
    public void extendTest() {
        WsConfig wsConfig = new WsConfig();
        Result result = new Result();
        result.setConfig(wsConfig);

        Assert.assertTrue(result.getConfig() instanceof WsConfig);
    }

    @Test
    public void implementTest() {
        Configuration configuration = new Configuration();
        Assert.assertTrue(configuration instanceof Configurable);
    }
}
