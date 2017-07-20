package com.oth.state;

import org.junit.Test;

/**
 * Created by anyanwen on 2016/11/7 15:59.
 */
    public class StateTest {

        @Test
        public void test() {
            Lift lift = new Lift(new CloseState());

            lift.start();
            lift.stop();
            lift.open();
            lift.close();
        }
    }
