package com.state;

/**
 * Created by anyanwen on 2016/11/7 15:47.
 */
public class OpenState implements State {

    @Override
    public void stop(Lift lift) {

    }

    @Override
    public void start(Lift lift) {

    }

    @Override
    public void open(Lift lift) {
        System.out.println("lift is opening");
    }

    @Override
    public void close(Lift lift) {
        final State state = new CloseState();
        lift.setState(state);
        state.close(lift);
    }
}
