package com.oth.state;

/**
 * Created by anyanwen on 2016/11/7 15:47.
 */
public class CloseState implements State {

    @Override
    public void stop(Lift lift) {
        
    }

    @Override
    public void start(Lift lift) {
        final State state = new StartState();
        lift.setState(state);
        state.start(lift);
    }

    @Override
    public void open(Lift lift) {
        final State state = new OpenState();
        lift.setState(state);
        state.open(lift);
    }

    @Override
    public void close(Lift lift) {
        System.out.println("lift is closing");
    }
}
