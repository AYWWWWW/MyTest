package com.state;

/**
 * Created by anyanwen on 2016/11/7 15:47.
 */
public class StartState implements State {

    @Override
    public void stop(Lift lift) {
        final State state = new StopState();
        lift.setState(state);
        state.stop(lift);
    }

    @Override
    public void start(Lift lift) {
        System.out.println("lift is starting");
    }

    @Override
    public void open(Lift lift) {

    }

    @Override
    public void close(Lift lift) {

    }
}
